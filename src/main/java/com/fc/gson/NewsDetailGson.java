package com.fc.gson;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class NewsDetailGson {
    private Long newsID;
    private String detailContent;
    private Timestamp updateAt;
    private String		updateBy = "sys";

    public Long getNewsID() {
        return newsID;
    }

    public void setNewsID(Long newsID) {
        this.newsID = newsID;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public static NewsDetailGson buildNewsDetailGson(String newsId, String detailContent) {
        NewsDetailGson detailGson = new NewsDetailGson();
        detailGson.setNewsID(Long.valueOf(newsId));
        detailGson.setDetailContent(detailContent);
        detailGson.setUpdateAt(Timestamp.valueOf(LocalDateTime.now()));
        detailGson.setUpdateBy("admin");
        return detailGson;
    }
}
