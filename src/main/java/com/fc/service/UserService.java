package com.fc.service;

import com.fc.gson.RetResultGson;
import com.fc.gson.UserInfoGson;
import com.fc.gson.UserInfoResultGson;
import com.fc.model.UserDTO;
import com.fc.util.GsonUtils;
import com.fc.util.JerseyClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fc.entity.Constant.*;
import static com.fc.entity.RetCode.*;


@Service
public class UserService {

    @Autowired
    private JerseyClient jerseyClient;

    private Logger logger = Logger.getLogger(UserService.class.getName());

    public UserInfoGson getProfile(String userId) {
        UserInfoGson userInfoGson = new UserInfoGson();
        try {
            String userInfoStr = jerseyClient.getHttp(String.format(GET_USERINFO, userId));
            UserInfoResultGson resultGson = GsonUtils.fromJson(userInfoStr, UserInfoResultGson.class);
            if (resultGson.getRetCode() == RET_CODE_OK) {
                userInfoGson.setNickName(resultGson.getNickName());
                userInfoGson.setCollege(resultGson.getCollege());
                userInfoGson.setPhoneNo(resultGson.getPhoneNumber());
                userInfoGson.setAvatarUrl(resultGson.getAvatarUrl());
                userInfoGson.setVerified(resultGson.getVerified() ? RET_VERIFIED_PASS : RET_VERIFIED_NOPASS);
            }
        } catch (Exception e) {
            logger.error("用户信息获取失败! userId=" + userId);
        }

        return userInfoGson;
    }

    public void updateUser(UserInfoGson userInfoGson) {
        try {
            Map<String, String> updateInfo = new HashMap<>();
            updateInfo.put("userID", userInfoGson.getID().toString());
            updateInfo.put("dto", GsonUtils.toJson(userInfoGson));
            String resp = jerseyClient.postHttp(String.format(UPDATE_USERINFO, userInfoGson.getID()), updateInfo);
            UserInfoResultGson userInfoResultGson = GsonUtils.fromJson(resp, UserInfoResultGson.class);
            if (userInfoResultGson.getRetCode() != RET_CODE_OK)
                throw new Exception(String.format("error=%s errmsg=%s",
                        userInfoResultGson.getRetCode(), userInfoResultGson.getMessage()));
        } catch (Exception e) {
            logger.error("用户信息更新失败");
        }
    }

    public RetResultGson updateHeadUrl(String userId, String avatarUrl) {
        RetResultGson resultGson = new RetResultGson(RET_CODE_OK, "SUCCESS");
        try {
            Map<String, String> requestParam = new HashMap<>();
            requestParam.put("avatarUrl", avatarUrl);
            avatarUrl = URLDecoder.decode(avatarUrl);
            String resp = jerseyClient.postHttp(String.format(UPDATE_AVATARURL, userId), requestParam);
            resultGson = GsonUtils.fromJson(resp, RetResultGson.class);
        } catch (Exception e) {
            logger.error("头像更新失败！ avatarUrl=" + avatarUrl);
            resultGson.setRetCode(RET_CODE_FAILURE);
        }
        return resultGson;
    }

    public List<UserDTO> listUserByTime() {
        List<UserDTO> userDTOList = new ArrayList<UserDTO>() {{
            add(UserDTO.buildUserDto(1, "水木清华",
                    "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
            add(UserDTO.buildUserDto(2, "梧桐树",
                    "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
            add(UserDTO.buildUserDto(3, "日月光华",
                    "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
            add(UserDTO.buildUserDto(4, "饮水思源",
                    "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
            add(UserDTO.buildUserDto(5, "小百合",
                    "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
        }};

        return userDTOList;
    }

    public List<UserDTO> listUserByHot() {
        List<UserDTO> userDTOList = new ArrayList<UserDTO>() {{
            add(UserDTO.buildUserDto(1, "水木清华", "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
            add(UserDTO.buildUserDto(2, "梧桐树", "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
            add(UserDTO.buildUserDto(3, "日月光华", "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
            add(UserDTO.buildUserDto(4, "饮水思源", "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
            add(UserDTO.buildUserDto(5, "小百合", "https://www.baidu.com/s?rsv_idx=1&tn=91694651_hao_pg&wd=%E7%AC%91%E8%84%B8%E5%9B%BE%E7%89%87&usm=1&ie=utf-8&rsv_cq=%E5%B0%8F%E5%9B%BE%E7%89%87&rsv_dl=0_right_recommends_20807&euri=b7bdd6eaf6efaf6e3148205a03b0d748"));
        }};

        return userDTOList;
    }
}

