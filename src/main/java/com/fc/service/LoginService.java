package com.fc.service;

import com.fc.gson.LoginRegisterGson;
import com.fc.gson.RetBeAdminLoginGson;
import com.fc.gson.RetResultGson;
import com.fc.gson.UserInfoResultGson;
import com.fc.util.GsonUtils;
import com.fc.util.JerseyClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.fc.entity.Constant.*;
import static com.fc.entity.RetCode.RET_CODE_FAILURE;
import static com.fc.entity.RetCode.RET_CODE_OK;

@Service
public class LoginService {

    @Autowired
    private JerseyClient jerseyClient;

    private Logger logger = Logger.getLogger(LoginService.class.getName());

    public RetResultGson getSmsCode(String phoneNo) {
        RetResultGson retResultGson = new RetResultGson(RET_CODE_OK, "");
        Map<String, String> cond = new HashMap<>();
        cond.put("phone", phoneNo);
        try {
            String response = jerseyClient.postHttp(SEND_SMS, cond);
            retResultGson = GsonUtils.fromJson(response, RetResultGson.class);
        } catch (Exception e) {
            logger.error("获取验证码失败！");
        }
        return retResultGson;
    }

    //登录
    public LoginRegisterGson login(String phoneNo, String smsCode) {
        Map<String, String> params = new HashMap<>();
        params.put("phoneNo", phoneNo);
        params.put("smsCode", smsCode);
//        RetResultGson retResultGson = new RetResultGson(RET_CODE_OK, "SUCCESS");
        LoginRegisterGson loginRegisterGson = new LoginRegisterGson(RET_CODE_OK, "SUCCESS");
        try {
            String resp = jerseyClient.postHttp(LOGIN_REGISTER, params);
            loginRegisterGson = GsonUtils.fromJson(resp, LoginRegisterGson.class);
            if (loginRegisterGson.getRetCode() == RET_CODE_OK) {
                String userResp = jerseyClient.getHttp(String.format(GET_USERINFO, loginRegisterGson.getUserId()));
                UserInfoResultGson userinfo = GsonUtils.fromJson(userResp, UserInfoResultGson.class);
                if (userinfo.getRetCode() == RET_CODE_OK)
                    loginRegisterGson.setAvatarUrl(userinfo.getAvatarUrl());
            }
        } catch (Exception e) {
            loginRegisterGson.setRetCode(RET_CODE_FAILURE);
            loginRegisterGson.setMessage("LOGIN FAILURE");
        }
        return loginRegisterGson;
    }

    public RetBeAdminLoginGson adminLogin(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        RetBeAdminLoginGson retBeAdminLoginGson = new RetBeAdminLoginGson(RET_CODE_OK, "SUCCESS");
        try {
            String resp = jerseyClient.postHttp(BE_ADMIN_LOGIN, params);
            retBeAdminLoginGson = GsonUtils.fromJson(resp, RetBeAdminLoginGson.class);
        } catch (Exception e) {
            retBeAdminLoginGson.setRetCode(RET_CODE_FAILURE);
            retBeAdminLoginGson.setMessage("beadmin login failure");
        }
        return retBeAdminLoginGson;
    }
}
