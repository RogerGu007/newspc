package com.fc.service;

import com.fc.entity.BBSEnum;
import com.fc.gson.MsgGson;
import com.fc.gson.NewsCountResultGson;
import com.fc.gson.NewsDetailResultGson;
import com.fc.gson.NewsSubjectResultGson;
import com.fc.model.NewsDetailDTO;
import com.fc.model.PageBean;
import com.fc.util.GsonUtils;
import com.fc.util.JerseyClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import static com.fc.entity.Constant.*;
import static com.fc.entity.RetCode.RET_CODE_OK;


@Service
public class PostService {

    @Autowired
    private JerseyClient jerseyClient;

    Logger logger = Logger.getLogger(PostService.class.getName());

//    public int publishPost(Post post) {
//        //构造帖子
//        post.setPublishTime(MyUtil.formatDate(new Date()));
//        post.setReplyTime(MyUtil.formatDate(new Date()));
//        post.setReplyCount(0);
//        post.setLikeCount(0);
//        post.setScanCount(0);
//        //插入一条帖子记录
//        postMapper.insertPost(post);
//        System.out.println(post.getPid());
//        return post.getPid();
//    }

    //按时间列出帖子
    public PageBean<MsgGson> listPostByTime(int location, int newsType, int subNewsType, int curPage) {
        //每页记录数，从哪开始
        int limit = 20;
        int offset = (curPage-1) * limit;
        //获得总记录数，总页数
        Map<String, String> newsMap = new HashMap<>();
        newsMap.put("location", String.valueOf(location));
        newsMap.put("newstype", String.valueOf(newsType));
        newsMap.put("page", String.valueOf(curPage-1));
        int allCount = 0;
        try {
            String getCountResp = jerseyClient.getHttp(GET_NEWS_COUNT, newsMap);
            NewsCountResultGson countResultGson = GsonUtils.fromJson(getCountResp, NewsCountResultGson.class);
            if (countResultGson != null && countResultGson.getRetCode() == RET_CODE_OK)
                allCount = countResultGson.getCount();
        } catch (Exception e) {
            logger.error(GET_NEWS_COUNT + " 获取news总数失败! " + e.getMessage());
        }

        int allPage = 0;
        if (allCount <= limit) {
            allPage = 1;
        } else if (allCount / limit == 0) {
            allPage = allCount / limit;
        } else {
            allPage = allCount / limit + 1;
        }
        PageBean<MsgGson> pageBean = new PageBean<>(allPage, curPage);

        if (subNewsType != 0)
            newsMap.put("subnewstype", String.valueOf(subNewsType));
        try {
            String response = jerseyClient.getHttp(GET_NEWS_LIST_SUBJECTS_BY_PAGE, newsMap);
            NewsSubjectResultGson resultGson = GsonUtils.fromJson(response, NewsSubjectResultGson.class);
            List<MsgGson> msgGsonList = resultGson.getMsgGsonList();

            for (MsgGson msg : msgGsonList) {
//                msg.setPublishSourceAvatarUrl(BBSEnum.userIdToBBS(msg.getPublisherId()).getAvatarUrl());
                //todo 由userId获取linkUrl
                if (BBSEnum.userIdToBBS(msg.getPublisherId()) != null)
                    msg.setPublishSourceLinkUrl(BBSEnum.userIdToBBS(msg.getPublisherId()).getLinkUrl());
                else
                    msg.setPublishSourceLinkUrl("/df/toMyProfile.do?userid=" + msg.getPublisherId());
            }
            pageBean.setList(msgGsonList);
        } catch (Exception e) {
            logger.error(GET_NEWS_LIST_SUBJECTS_BY_PAGE + " failed! " + e.getMessage());
        }

        return pageBean;
    }

    public NewsDetailDTO getPostDetail(Long newsId) {
        //更新浏览数
//        postMapper.updateScanCount(newsId);
        Map<String, String> newsMap = new HashMap<>();
        newsMap.put("newsid", String.valueOf(newsId));
//        newsMap.put("userid", String.valueOf(userId));
        NewsDetailDTO newsDetailDTO = null;
        try {
            String response = jerseyClient.getHttp(GET_NEWS_DETAIL, newsMap);
            NewsDetailResultGson newsDetailResultGson
                    = GsonUtils.fromJson(response, NewsDetailResultGson.class);
            if (newsDetailResultGson.getRetCode() == RET_CODE_OK) {
                newsDetailDTO = newsDetailResultGson.getNewsDetailDTO();
            }
        } catch (Exception e) {
            logger.warn(GET_NEWS_DETAIL + " failed! " + e.getMessage());
        }

        return newsDetailDTO;

//        Post post = postMapper.getPostByPid(pid);
//        //设置点赞数
//        Jedis jedis = jedisPool.getResource();
//        long likeCount = jedis.scard(pid+":like");
//        post.setLikeCount((int)likeCount);
//
//        if(jedis!=null){
//            jedisPool.returnResource(jedis);
//        }
//        return post;
    }

    //根据uid，获得帖子列表
    public List<MsgGson> getFavourNewsList(String userId) {
        try {
            String resp = jerseyClient.getHttp(GET_FAVOURITE_NEWS, new HashMap<String, String>() {{
                put("userid", userId);
            }});
            NewsSubjectResultGson resultGson = GsonUtils.fromJson(resp, NewsSubjectResultGson.class);
            if (resultGson.getRetCode() == RET_CODE_OK) {
                List<MsgGson> msgGsonList = resultGson.getMsgGsonList();
                for (MsgGson msg : msgGsonList) {
                    String detail = jerseyClient.getHttp(GET_NEWS_DETAIL, new HashMap<String, String>() {{
                        put("newsid", msg.getID());
                    }});
                    NewsDetailResultGson detailGson = GsonUtils.fromJson(detail, NewsDetailResultGson.class);
                    if (detailGson.getRetCode() == RET_CODE_OK)
                        msg.setPublisherId(detailGson.getNewsDetailDTO().getPublisher_id());
                }
                return msgGsonList;
            }
        } catch (Exception e) {
            logger.info("收藏列表获取失败 userId=" + userId);
        }
        return new ArrayList<>();
    }
}

