package com.fc.service;

import com.fc.entity.RetCode;
import com.fc.gson.NewsFavoriteResultGson;
import com.fc.gson.RetResultGson;
import com.fc.util.GsonUtils;
import com.fc.util.JerseyClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static com.fc.entity.Constant.*;

@Service
public class NewsService {
    @Autowired
    private JerseyClient jerseyClient;

    Logger logger = Logger.getLogger(NewsService.class.getName());

    public NewsFavoriteResultGson getIsFavorite(String newsId, String userId) {
        NewsFavoriteResultGson resultGson = new NewsFavoriteResultGson(RetCode.RET_CODE_OK, RetCode.RET_STATUS_SUCCESS);
        resultGson.setFavorite(false);
        if (StringUtils.isEmpty(userId))
            return resultGson;

        Map<String, String> param = new HashMap<>();
        param.put("newsid", newsId);
        param.put("userid", userId);
        String resp = jerseyClient.getHttp(GET_IS_FAVOURITE, param);
        return GsonUtils.fromJson(resp, NewsFavoriteResultGson.class);
    }

    public NewsFavoriteResultGson addOrRemoveFavor(Boolean bAdd, String newsId, String userId) {
        NewsFavoriteResultGson resultGson = new NewsFavoriteResultGson(RetCode.RET_CODE_OK, RetCode.RET_STATUS_SUCCESS);
        Map<String, String> param = new HashMap<>();
        param.put("addordelete", String.valueOf(bAdd));
        param.put("newsid", newsId);
        param.put("userid", userId);
        String resp = jerseyClient.postHttp(ADD_OR_REMOVE_FAVOURITE, param);
        return GsonUtils.fromJson(resp, NewsFavoriteResultGson.class);
    }

    public NewsFavoriteResultGson clearFav(String userId) {
        NewsFavoriteResultGson resultGson = new NewsFavoriteResultGson(RetCode.RET_CODE_OK, RetCode.RET_STATUS_SUCCESS);
        Map<String, String> param = new HashMap<>();
        param.put("userid", userId);
        String resp = jerseyClient.postHttp(CLEAR_FAVOURITE, param);
        return GsonUtils.fromJson(resp, NewsFavoriteResultGson.class);
    }

    public RetResultGson deleteNews(String newsId) {
        Map<String, String> param = new HashMap<>();
        param.put("newsid", newsId);
        param.put("isvalid", "false");
        String resp = jerseyClient.postHttp(DELETE_NEWS, param);
        RetResultGson resultGson = GsonUtils.fromJson(resp, RetResultGson.class);
        return resultGson;
    }
}
