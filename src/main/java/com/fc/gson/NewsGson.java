package com.fc.gson;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class NewsGson {
    private Long ID;
    private String 	subject;
    private String	newsType;
    private String	newsSubType;
    private String    locationCode;
    private Timestamp updateAt;
    private String		updateBy = "sys";

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public Long getID() {
        return ID;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public String getNewsSubType() {
        return newsSubType;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public void setNewsSubType(String newsSubType) {
        this.newsSubType = newsSubType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public static NewsGson buildNewsGson(String newsId, String subject, String newsType, String newsSubType, String locationCode) {
        NewsGson newsGson = new NewsGson();
        newsGson.setID(Long.valueOf(newsId));
        newsGson.setSubject(!StringUtils.isEmpty(subject) ? subject : null);
        newsGson.setNewsType(!StringUtils.isEmpty(newsType) ? newsType : null);
        newsGson.setNewsSubType(!StringUtils.isEmpty(newsSubType) ? newsSubType : null);
        newsGson.setLocationCode(!StringUtils.isEmpty(locationCode) ? locationCode : null);
        newsGson.setUpdateAt(Timestamp.valueOf(LocalDateTime.now()));
        newsGson.setUpdateBy("admin");
        return newsGson;
    }
}
