package com.fc.service;

import com.fc.async.MailTask;
import com.fc.gson.HttpResult;
import com.fc.gson.RetResultGson;
import com.fc.gson.UserInfoGson;
import com.fc.gson.UserInfoResultGson;
import com.fc.mapper.UserMapper;
import com.fc.model.Info;
import com.fc.model.User;
import com.fc.util.GsonUtils;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fc.entity.Constant.*;
import static com.fc.entity.RetCode.*;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private HttpClientOperateService httpClientOperateService;

    private Logger logger = Logger.getLogger(UserService.class.getName());

    public User getProfile(int sessionUid, int uid) {
        //如果是浏览别人的主页，则增加主页浏览数
        if(sessionUid!=uid){
            userMapper.updateScanCount(uid);
        }
        //从数据库得到User对象
        User user = userMapper.selectUserByUid(uid);
        //设置获赞数，关注数，粉丝数
        Jedis jedis = jedisPool.getResource();
        user.setFollowCount((int)(long)jedis.scard(uid+":follow"));
        user.setFollowerCount((int)(long)jedis.scard(uid+":fans"));
        String likeCount = jedis.hget("vote",uid+"");
        if(likeCount==null){
            user.setLikeCount(0);
        }else {
            user.setLikeCount(Integer.valueOf(likeCount));
        }

        if(jedis!=null){
            jedisPool.returnResource(jedis);
        }
        return user;
    }

    public User getEditInfo(int uid) {
        return userMapper.selectEditInfo(uid);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void record(StringBuffer requestURL, String contextPath, String remoteAddr) {
        Info info = new Info();
        info.setRequestUrl(requestURL.toString());
        info.setContextPath(contextPath);
        info.setRemoteAddr(remoteAddr);
        userMapper.insertInfo(info);
    }

    public List<User> listUserByTime() {
        return userMapper.listUserByTime();
    }

    public List<User> listUserByHot() {
        return userMapper.listUserByHot();
    }

    public void unfollow(int sessionUid, int uid) {
        Jedis jedis = jedisPool.getResource();
        Transaction tx = jedis.multi();
        tx.srem(sessionUid+":follow", String.valueOf(uid));
        tx.srem(uid+":fans", String.valueOf(sessionUid));
        tx.exec();

        if(jedis!=null){
            jedisPool.returnResource(jedis);
        }
    }

    public void follow(int sessionUid, int uid) {
        Jedis jedis = jedisPool.getResource();
        Transaction tx = jedis.multi();
        tx.sadd(sessionUid+":follow", String.valueOf(uid));
        tx.sadd(uid+":fans", String.valueOf(sessionUid));
        tx.exec();
        if(jedis!=null){
            jedisPool.returnResource(jedis);
        }
    }

    public boolean getFollowStatus(int sessionUid, int uid) {
        Jedis jedis = jedisPool.getResource();
        boolean following = jedis.sismember(sessionUid+":follow", String.valueOf(uid));
        if(jedis!=null){
            jedisPool.returnResource(jedis);
        }
        return following;
    }

    public String updatePassword(String password, String newpassword, String repassword, int sessionUid) {

        String oldPassword = userMapper.selectPasswordByUid(sessionUid);
        if(!oldPassword.equals(password)){
            return "原密码输入错误~";
        }

        if(newpassword.length()<6 ||newpassword.length()>20){
            return "新密码长度要在6~20之间~";
        }

        if(!newpassword.equals(repassword)){
            return "新密码两次输入不一致~";
        }

        userMapper.updatePassword(newpassword,sessionUid);
        return "ok";
    }

    //发送忘记密码确认邮件
    public void forgetPassword(String email) {
        String verifyCode = userMapper.selectVerifyCode(email);
        System.out.println("verifyCode:"+verifyCode);
        //发送邮件
        taskExecutor.execute(new MailTask(verifyCode,email,javaMailSender,2));
    }

    public void verifyForgetPassword(String code) {
        System.out.println("更新前："+code);
        userMapper.updatePasswordByActivateCode(code);
        System.out.println("更新后："+code);
    }


    public UserInfoGson getProfile(String userId) {
        UserInfoGson userInfoGson = new UserInfoGson();
        try {
            String userInfoStr = httpClientOperateService.doGet(String.format(GET_USERINFO, userId));
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
            HttpResult result =
                    httpClientOperateService.doPost(String.format(UPDATE_USERINFO, userInfoGson.getID()), updateInfo);
            UserInfoResultGson userInfoResultGson = GsonUtils.fromJson(result.getContent(), UserInfoResultGson.class);
            if (userInfoResultGson.getRetCode() != RET_CODE_OK)
                throw new Exception(String.format("error=%s errmsg=%s",
                        userInfoResultGson.getRetCode(), userInfoResultGson.getMessage()));
        } catch (Exception e) {
            logger.error("用户信息更新失败");
        }
    }

    public RetResultGson updateHeadUrl(String userId, String avatarUrl) {
//        userMapper.updateHeadUrl(uid,headUrl);
        RetResultGson resultGson = new RetResultGson(RET_CODE_OK, "SUCCESS");
        try {
            Map<String, String> requestParam = new HashMap<>();
            requestParam.put("avatarUrl", avatarUrl);
            avatarUrl = URLDecoder.decode(avatarUrl);
            HttpResult httpResult = httpClientOperateService.doPost(String.format(UPDATE_AVATARURL, userId), requestParam);
            resultGson = GsonUtils.fromJson(httpResult.getContent(), RetResultGson.class);
        } catch (Exception e) {
            logger.error("头像更新失败！ avatarUrl=" + avatarUrl);
            resultGson.setRetCode(RET_CODE_FAILURE);
        }
        return resultGson;
    }
}

