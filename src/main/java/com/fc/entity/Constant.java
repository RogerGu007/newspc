package com.fc.entity;

public class Constant {

    public static String NEWS_REMOTE_ADDRESS = "http://47.100.197.44/news/rest";
    public static String GET_NEWS_LIST_SUBJECTS_BY_PAGE = NEWS_REMOTE_ADDRESS + "/news/getnewslistsubjectsbypage";
    public static String GET_NEWS_DETAIL = NEWS_REMOTE_ADDRESS + "/news/getnewsdetail";
    public static String GET_NEWS_COUNT = NEWS_REMOTE_ADDRESS + "/news/getnewscount";
    public static String GET_COMMENTS = NEWS_REMOTE_ADDRESS + "/comment/getcomments";
    public static String SEND_SMS = NEWS_REMOTE_ADDRESS + "/login/sendSms";
    public static String LOGIN_REGISTER = NEWS_REMOTE_ADDRESS + "/login/loginregister";
    public static String GET_USERINFO = NEWS_REMOTE_ADDRESS + "/user/%s/getuserinfo";
    public static String ADD_COMMENT = NEWS_REMOTE_ADDRESS + "/comment/addcomment";
    public static String REPLY_COMMENT = NEWS_REMOTE_ADDRESS + "/comment/replycomment";
}
