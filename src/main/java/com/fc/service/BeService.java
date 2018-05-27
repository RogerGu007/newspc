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

    public RetResultGson updateNewsSubejct(String sessionId, String adminID, NewsGson newsGson) {
        Map<String, String> param = new HashMap<>();
        param.put("dto", GsonUtils.toJson(newsGson));
        Map<String, String> header = new HashMap<>();
        header.put("SessionID", sessionId);
        header.put("beadminID", adminID);
        String resp = jerseyClient.postHttp(UPDATE_NEWS_SUBJECT, param, header);
        RetResultGson resultGson = GsonUtils.fromJson(resp, RetResultGson.class);
        return resultGson;
    }

    public RetResultGson updateNewsDetail(String sessionId, String adminID, NewsDetailGson detailGson) {
        Map<String, String> param = new HashMap<>();
        param.put("dto", GsonUtils.toJson(detailGson));
        Map<String, String> header = new HashMap<>();
        header.put("SessionID", sessionId);
        header.put("beadminID", adminID);
        String resp = jerseyClient.postHttp(UPDATE_NEWS_DETAIL, param, header);
        RetResultGson resultGson = GsonUtils.fromJson(resp, RetResultGson.class);
        return resultGson;
    }
}