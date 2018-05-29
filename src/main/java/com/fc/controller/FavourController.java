package com.fc.controller;

import com.fc.entity.RetCode;
import com.fc.gson.NewsFavoriteResultGson;
import com.fc.service.NewsService;
import com.fc.util.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.fc.entity.RetCode.RET_CODE_OK;
import static com.fc.entity.RetCode.RET_STATUS_SUCCESS;

@Controller
@RequestMapping("/")
public class FavourController {

    @Autowired
    NewsService newsService;

    //判断是否收藏过
    @RequestMapping(value = "/getIsFavorite.do", method = RequestMethod.POST)
    public @ResponseBody
    NewsFavoriteResultGson isFavourite(String newsId, String userId){
        if (StringUtils.isEmpty(newsId) || StringUtils.isEmpty(userId)) {
            NewsFavoriteResultGson resultGson =
                    new NewsFavoriteResultGson(RetCode.RET_CODE_REQUIREEMPTY, RetCode.RET_STATUS_FAILURE);
            return resultGson;
        }

        NewsFavoriteResultGson resultGson = newsService.getIsFavorite(newsId, userId);
        return resultGson;
    }

    //收藏、取消收藏
    @RequestMapping(value = "/addorremovefavoritenews.do", method = RequestMethod.POST)
    public @ResponseBody
    NewsFavoriteResultGson addOrRemoveFavourite(Boolean bAdd, String newsId, String userId){
        if (StringUtils.isEmpty(newsId) || StringUtils.isEmpty(userId)) {
            NewsFavoriteResultGson resultGson =
                    new NewsFavoriteResultGson(RetCode.RET_CODE_REQUIREEMPTY, RetCode.RET_STATUS_FAILURE);
            return resultGson;
        }

        if (bAdd == null)
            bAdd = false;

        NewsFavoriteResultGson resultGson = newsService.addOrRemoveFavor(bAdd, newsId, userId);
        return resultGson;
    }

    @RequestMapping(value = "/clearfav.do", method = RequestMethod.POST)
    public @ResponseBody
    NewsFavoriteResultGson clearFav(String userid) {
        NewsFavoriteResultGson resultGson = newsService.clearFav(userid);
        return resultGson;
    }
}
