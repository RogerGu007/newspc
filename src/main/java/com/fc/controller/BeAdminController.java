package com.fc.controller;

import com.fc.gson.NewsDetailGson;
import com.fc.gson.NewsGson;
import com.fc.gson.RetResultGson;
import com.fc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.fc.entity.RetCode.RET_CODE_FAILURE;
import static com.fc.entity.RetCode.RET_CODE_OK;
import static com.fc.entity.RetCode.RET_STATUS_SUCCESS;

@Controller
@RequestMapping("/")
public class BeAdminController {

    @Autowired
    private BeService beService;

    //去帖子详情页面
    @RequestMapping(value = "/editPost.do", produces = "application/json;charset=utf-8")
    public String toPost(){
        return "editPost";
    }

    @RequestMapping(value = "/editNews.do", produces = "application/json;charset=utf-8")
    public @ResponseBody
    RetResultGson editNews(String sessionId, String newsid, String linkUrl, String subject, String content,
                           String newsType, String subNewsType, String locationCode) {
        if (StringUtils.isEmpty(sessionId) || (StringUtils.isEmpty(newsid) && StringUtils.isEmpty(linkUrl))) {
            return new RetResultGson(RET_CODE_FAILURE, "未登录或newsId/linkUrl为空!");
        }

        //更新news
        NewsGson newsGson = NewsGson.buildNewsGson(newsid, subject, newsType, subNewsType, locationCode);
        RetResultGson resultGson = beService.updateNewsSubejct(sessionId, newsGson);
        if (resultGson.getRetCode() != RET_CODE_OK)
            return resultGson;
        if (!StringUtils.isEmpty(content)) {
            //更新详情
            NewsDetailGson detailGson = NewsDetailGson.buildNewsDetailGson(newsid, content);
            resultGson = beService.updateNewsDetail(sessionId, detailGson);
            if (resultGson.getRetCode() != RET_CODE_OK)
                return resultGson;
        }

        return new RetResultGson(RET_CODE_OK, RET_STATUS_SUCCESS);
    }
}
