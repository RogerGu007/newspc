package com.fc.gson;

public class CommentListRequestGson {
    String newsID;
    String userID;
    String comment;

    public String getNewsID() {
        return newsID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static CommentListRequestGson buildReq(String newsID, String userID, String comment) {
        CommentListRequestGson cr = new CommentListRequestGson();
        cr.setNewsID(newsID);
        cr.setUserID(userID);
        cr.setComment(comment);
        return cr;
    }
}
