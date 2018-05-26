package com.fc.service;

import com.fc.gson.NewsDetailGson;
import com.fc.gson.NewsGson;
import com.fc.gson.RetResultGson;
import com.fc.util.GsonUtils;
import com.fc.util.JerseyClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.fc.entity.Constant.UPDATE_NEWS_DETAIL;
import static com.fc.entity.Constant.UPDATE_NEWS_SUBJECT;

@Service
public class BeService {
    @Autowired
    private JerseyClient jerseyClient;

    private Logger logger = Logger.getLogger(BeService.class.getName());

    public RetResultGson updateNewsSubejct(String sessionId, NewsGson newsGson) {
        Map<String, String> param = new HashMap<>();
        param.put("SessionID", sessionId);
        param.put("dto", GsonUtils.toJson(newsGson));
        String resp = jerseyClient.postHttp(UPDATE_NEWS_SUBJECT, param);
        RetResultGson resultGson = GsonUtils.fromJson(resp, RetResultGson.class);
        return resultGson;
    }

    public RetResultGson updateNewsDetail(String sessionId, NewsDetailGson detailGson) {
        Map<String, String> param = new HashMap<>();
        param.put("SessionID", sessionId);
        param.put("dto", GsonUtils.toJson(detailGson));
        String resp = jerseyClient.postHttp(UPDATE_NEWS_DETAIL, param);
        RetResultGson resultGson = GsonUtils.fromJson(resp, RetResultGson.class);
        return resultGson;
    }
}
