package com.fc.entity;

public class Constant {
    public static String DOMAIN_HOST = "47.100.197.44"; //后面改成域名方式
    public static String GET_NEWS_LIST_SUBJECTS_BY_PAGE = "/news/getnewslistsubjectsbypage";
    public static String GET_NEWS_DETAIL = "/news/getnewsdetail";
    public static String GET_NEWS_BY_ID = "/news/getnewsbyid";
    public static String GET_NEWS_COUNT = "/news/getnewscount";
    public static String GET_COMMENTS = "/comment/getcomments";
    public static String SEND_SMS = "/login/sendSms";
    public static String LOGIN_REGISTER = "/login/loginregister";
    public static String GET_USERINFO = "/user/%s/getuserinfo";
    public static String ADD_COMMENT = "/comment/addcomment";
    public static String REPLY_COMMENT = "/comment/replycomment";
    public static String GET_FAVOURITE_NEWS = "/news/getfavoritenews";
    public static String UPDATE_USERINFO = "/user/%s/updateuserinfo";
    public static String UPDATE_AVATARURL = "/user/%s/updateavatarUrl";
    public static String BE_ADMIN_LOGIN = "/beadmin/login";
    public static String UPDATE_NEWS_SUBJECT = "/news/updatenewssubject";
    public static String UPDATE_NEWS_DETAIL = "/news/updatenewsdetail";
    public static String DELETE_NEWS = "/news/updatenews";
    public static String GET_IS_FAVOURITE = "/news/getisfavorite";
    public static String ADD_OR_REMOVE_FAVOURITE = "/news/addorremovefavoritenews";
    public static String CLEAR_FAVOURITE = "/news/clearfav";
    public static String GET_MY_POST = "/news/getpostnews";

    public static String DEFAULT_AVATAR = "image/avatar/avator_default.png";
}
