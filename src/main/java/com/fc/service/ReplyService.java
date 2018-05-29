package com.fc.service;

import com.fc.gson.*;
import com.fc.model.*;
import com.fc.util.GsonUtils;
import com.fc.util.JerseyClient;
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
import static com.fc.entity.RetCode.RET_STATUS_SUCCESS;


@Service
public class ReplyService {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private JerseyClient jerseyClient;

//    @Autowired
//    private JerseyClientUtil jerseyClientUtil;

    private Logger logger = Logger.getLogger(ReplyService.class.getName());

    //根据pid列出回复
    public List<FirstLevelCommentDTO> listReply(Long newsId, int page) {
        List<FirstLevelCommentDTO> replyList = new ArrayList<>();
        //列出回复
        Map<String, String> params = new HashMap<>();
        params.put("newsID", String.valueOf(newsId));
        params.put("page", String.valueOf(page));
        params.put("pageSize", "20");
        try {
//            String comments = httpClientOperateService.doGet(GET_COMMENTS, cond);
            String comments = jerseyClient.getHttp(GET_COMMENTS, params);
            CommentsResultGson commentsResultGson = GsonUtils.fromJson(comments, CommentsResultGson.class);
            if (commentsResultGson.getRetCode() == RET_CODE_OK) {
                replyList = commentsResultGson.getFirstLevelCommentDTOS();
            }
        } catch (Exception e) {
            logger.error(GET_COMMENTS + " falied! " + e.getMessage());
        }
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
            String response = jerseyClient.postHttp(ADD_COMMENT, contentMap);
//            HttpResult result = httpClientOperateService.doPost(ADD_COMMENT, contentMap);
//            Response result = jerseyClientUtil.postHttp(ADD_COMMENT, contentMap);
//            retFLCommentResultGson = GsonUtils.fromJson(result.getEntity().toString(), RetFLCommentResultGson.class);
            retFLCommentResultGson = GsonUtils.fromJson(response, RetFLCommentResultGson.class);
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
    public RetSecCommentResultGson secondReply(String firstReplyId, String fromUserID,
                                               String toUserID, String replyComment) {
        RetSecCommentResultGson resultGson = new RetSecCommentResultGson(RET_CODE_OK, RET_STATUS_SUCCESS);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("flID", firstReplyId);
        paramMap.put("fromUserID", fromUserID);
        paramMap.put("toUserID", toUserID);
        paramMap.put("replyComment", filterHtml(replyComment));
        try {
            String resp = jerseyClient.postHttp(REPLY_COMMENT, paramMap);
//            HttpResult httpResult = httpClientOperateService.doPost(REPLY_COMMENT, replyCond);
            resultGson = GsonUtils.fromJson(resp, RetSecCommentResultGson.class);
            if (resultGson.getRetCode() != RET_CODE_OK)
                throw new Exception(resultGson.getMessage());
        } catch (Exception e) {
            logger.error(String.format("回复评论错误 firstReplyId=%s, fromUserID=%s, toUserID=%s  %s",
                    firstReplyId, fromUserID, toUserID, e.getMessage()));
        }
        return resultGson;
    }

    private String filterHtml(String content) {
        String regexHtml = "<[^>]+>"; //定义HTML标签的正则表达式
        return Pattern.compile(regexHtml, Pattern.CASE_INSENSITIVE)
                .matcher(content).replaceAll("");
    }
}

