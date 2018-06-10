package com.fc.service;

import com.fc.entity.BBSEnum;
import com.fc.gson.*;
import com.fc.model.NewsDetailDTO;
import com.fc.model.PageBean;
import com.fc.model.UserDTO;
import com.fc.util.GsonUtils;
import com.fc.util.JerseyClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

import static com.fc.entity.Constant.*;
import static com.fc.entity.RetCode.RET_CODE_OK;
import static com.fc.entity.SourceEnum.OURSITE;


@Service
public class PostService {

    @Autowired
    private JerseyClient jerseyClient;

    @Autowired
    private UserService userService;

    Logger logger = Logger.getLogger(PostService.class.getName());

    private static Integer DEFAULT_PAGE_SIZE = 15;

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
//        int offset = (curPage-1) * DEFAULT_PAGE_SIZE;
        //获得总记录数，总页数
        Map<String, String> newsMap = new HashMap<>();
        newsMap.put("location", String.valueOf(location));
        newsMap.put("newstype", String.valueOf(newsType));
        newsMap.put("page", String.valueOf(curPage-1));
        newsMap.put("pageSize", String.valueOf(DEFAULT_PAGE_SIZE));
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
        if (allCount <= DEFAULT_PAGE_SIZE) {
            allPage = 1;
        } else if (allCount / DEFAULT_PAGE_SIZE == 0) {
            allPage = allCount / DEFAULT_PAGE_SIZE;
        } else {
            allPage = allCount / DEFAULT_PAGE_SIZE + 1;
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
                    msg.setPublishSourceLinkUrl("/df/toProfile.do?userid=" + msg.getPublisherId());
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
        NewsDetailDTO newsDetailDTO = new NewsDetailDTO();
        try {
            String response = jerseyClient.getHttp(GET_NEWS_BY_ID, newsMap);
            NewsSubjectResultGson newsSubjectResultGson =
                    GsonUtils.fromJson(response, NewsSubjectResultGson.class);
            if (newsSubjectResultGson.getRetCode() == RET_CODE_OK
                    && (newsSubjectResultGson.getMsgGsonList() != null
                    && newsSubjectResultGson.getMsgGsonList().size() > 0)) {
                //重组newsDetailDTO
                MsgGson msgGson = newsSubjectResultGson.getMsgGsonList().get(0);
                newsDetailDTO.setNewsID(Long.valueOf(msgGson.getID()));
                newsDetailDTO.setPostDate(msgGson.getPostDate());
                newsDetailDTO.setPublisher_id(msgGson.getPublisherId());
                newsDetailDTO.setPublisher_name(msgGson.getPublishSource());
                newsDetailDTO.setPublisher_avatar_url(msgGson.getPublishAvatar());
                newsDetailDTO.setSubject(msgGson.getContent());
                newsDetailDTO.setFavorite(msgGson.getFavorite());
                newsDetailDTO.setDetailContent(msgGson.getDetailContent());

                String detailContent = msgGson.getDetailContent();
                //用户自己的发帖
                if (msgGson.getSource().equals(OURSITE.getSourceDesc())) {
                    List<String> imageList = msgGson.getImagePaths();
                    if (imageList != null) {
                        for (String image : imageList) {
                            detailContent += renderImageHtml(image);
                        }
                    }
                    newsDetailDTO.setDetailContent(detailContent);
                }
            }
        } catch (Exception e) {
            logger.warn(GET_NEWS_DETAIL + " failed! " + e.getMessage());
        }

        newsDetailDTO.setDetailContent(addHead(newsDetailDTO.getDetailContent()));
        return newsDetailDTO;
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

    public List<MsgGson> myPost(String userId) {
        String resp = jerseyClient.getHttp(GET_MY_POST, new HashMap<String, String>() {{
            put("userid", userId);
            put("page", "0");
        }});

        NewsSubjectResultGson resultGson = GsonUtils.fromJson(resp, NewsSubjectResultGson.class);
        if (resultGson.getRetCode() == RET_CODE_OK) {
            return resultGson.getMsgGsonList();
        }
        return new ArrayList<>();
    }

    private String renderImageHtml(String oriImagePath) {
        if (!oriImagePath.contains("http")) {
            return String.format("<br><img src=\"http://%s/asset/%s\"></br>", DOMAIN_HOST, oriImagePath);
        }
        return String.format("<br><img src=\"%s\"></br>", oriImagePath);
    }

    private String addHead(String content) {
        if (!StringUtils.isEmpty(content) && content.contains("</head>"))
            content = "<head><meta name=\"referrer\" content=\"no-referrer\"></head>" + content;
        return content;
    }
}

