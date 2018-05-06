package com.fc.service;

import com.fc.async.MessageTask;
import com.fc.gson.CommentsResultGson;
import com.fc.gson.HttpResult;
import com.fc.gson.RetFLCommentResultGson;
import com.fc.gson.RetSecCommentResultGson;
import com.fc.mapper.MessageMapper;
import com.fc.mapper.PostMapper;
import com.fc.mapper.ReplyMapper;
import com.fc.mapper.UserMapper;
import com.fc.model.*;
import com.fc.util.GsonUtils;
import com.fc.util.MyConstant;
import com.google.gson.Gson;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static com.fc.entity.Constant.ADD_COMMENT;
import static com.fc.entity.Constant.GET_COMMENTS;
import static com.fc.entity.Constant.REPLY_COMMENT;
import static com.fc.entity.RetCode.RET_CODE_FAILURE;
import static com.fc.entity.RetCode.RET_CODE_OK;


@Service
public class ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private HttpClientOperateService httpClientOperateService;

    private Logger logger = Logger.getLogger(ReplyService.class.getName());

    //回复
    public void reply(int sessionUid, int pid, String content) {
        //构造Reply对象
        User user = new User(sessionUid);
        Post post = new Post(pid);
        Reply reply = new Reply();
        reply.setUser(user);
        reply.setPost(post);
        reply.setContent(content);
        //向reply表插入一条记录
        replyMapper.insertReply(reply);
        //更新帖子的回复数
        postMapper.updateReplyCount(pid);
        //更新最后回复时间
        postMapper.updateReplyTime(pid);
        //插入一条回复消息
        taskExecutor.execute(new MessageTask(messageMapper,userMapper,postMapper,replyMapper,pid,0,sessionUid, MyConstant.OPERATION_REPLY));
    }

    //评论
    public void comment(int pid,int sessionUid, int rid, String content) {
        //构造Comment
        User user = new User(sessionUid);
        Reply reply = new Reply(rid);
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setReply(reply);
        comment.setContent(content);
        //插入一条评论
        replyMapper.insertComment(comment);
        //更新最后回复时间
        postMapper.updateReplyTime(pid);
        //插入一条评论消息
        taskExecutor.execute(new MessageTask(messageMapper,userMapper,postMapper,replyMapper,pid,rid,sessionUid, MyConstant.OPERATION_COMMENT));
    }

    //根据pid列出回复
    public List<FirstLevelCommentDTO> listReply(int newsId, int page) {
        List<FirstLevelCommentDTO> replyList = new ArrayList<>();
        //列出回复
        Map<String, String> cond = new HashMap<>();
        cond.put("newsID", String.valueOf(newsId));
        cond.put("page", String.valueOf(page));
        cond.put("pageSize", "20");
        try {
            String comments = httpClientOperateService.doGet(GET_COMMENTS, cond);
            CommentsResultGson commentsResultGson = GsonUtils.fromJson(comments, CommentsResultGson.class);
            if (commentsResultGson.getRetCode() == RET_CODE_OK) {
                replyList = commentsResultGson.getFirstLevelCommentDTOS();
            }
        } catch (Exception e) {
            logger.error(GET_COMMENTS + " falied! " + e.getMessage());
        }
//        List<Reply> replyList = replyMapper.listReply(pid);
//        for(Reply reply : replyList){
//            //列出每条回复下的评论
//            List<Comment> commentList = replyMapper.listComment(reply.getRid());
//            reply.setCommentList(commentList);
//        }
        return replyList;
    }

    //回复
    public RetFLCommentResultGson reply(String newsid, String userid, String content) {
        RetFLCommentResultGson retFLCommentResultGson = new RetFLCommentResultGson(RET_CODE_OK, "SUCCESS");
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("newsID", newsid.toString());
        contentMap.put("userID", userid.toString());
        contentMap.put("comment", filterHtml(content));
        try {
            HttpResult result = httpClientOperateService.doPost(ADD_COMMENT, contentMap);
            retFLCommentResultGson = GsonUtils.fromJson(result.getContent(), RetFLCommentResultGson.class);
            if (retFLCommentResultGson.getRetCode() != RET_CODE_OK)
                retFLCommentResultGson.setRetCode(RET_CODE_FAILURE);
        } catch (Exception e) {
            retFLCommentResultGson.setRetCode(RET_CODE_FAILURE);
            retFLCommentResultGson.setMessage("写入评论失败!");
            logger.error("写入评论失败！");
        }
        return retFLCommentResultGson;
    }

    //评论
    public void secondReply(String firstReplyId, String fromUserID, String toUserID, String replyComment) {
        Map<String, String> replyCond = new HashMap<>();
        replyCond.put("flID", firstReplyId);
        replyCond.put("fromUserID", fromUserID);
        replyCond.put("toUserID", toUserID);
        replyCond.put("replyComment", filterHtml(replyComment));
        try {
            HttpResult httpResult = httpClientOperateService.doPost(REPLY_COMMENT, replyCond);
            RetSecCommentResultGson resultGson =
                    GsonUtils.fromJson(httpResult.getContent(), RetSecCommentResultGson.class);
            if (resultGson.getRetCode() != RET_CODE_OK)
                throw new Exception(resultGson.getMessage());
        } catch (Exception e) {
            logger.error(String.format("回复评论错误 firstReplyId=%s, fromUserID=%s, toUserID=%s  %s",
                    firstReplyId, fromUserID, toUserID, e.getMessage()));
        }
    }

    private String filterHtml(String content) {
        String regexHtml = "<[^>]+>"; //定义HTML标签的正则表达式
        return Pattern.compile(regexHtml, Pattern.CASE_INSENSITIVE)
                .matcher(content).replaceAll("");
    }
}

