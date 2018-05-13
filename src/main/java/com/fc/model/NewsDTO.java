package com.fc.model;

import java.sql.Timestamp;

public class NewsDTO extends BaseDTO {
    private String 	subject;
    private Integer	newsType;
    private Integer	newsSubType;
    private Timestamp postDate;	//post的时间
    private Integer    locationCode;	//地点，可以更加学校所在地填写
    private Integer    isHot;		//是否热点
    private String     linkUrl;
    private Long 		publisherId;
    private String     publishSource;
    private String publishSourceAvatarUrl;
    private String publishSourceLinkUrl;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public Integer getNewsSubType() {
        return newsSubType;
    }

    public void setNewsSubType(Integer newsSubType) {
        this.newsSubType = newsSubType;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public Integer getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(Integer locationCode) {
        this.locationCode = locationCode;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublishSource() {
        return publishSource;
    }

    public void setPublishSource(String publishSource) {
        this.publishSource = publishSource;
    }

    public String getPublishSourceAvatarUrl() {
        return publishSourceAvatarUrl;
    }

    public void setPublishSourceAvatarUrl(String publishSourceAvatarUrl) {
        this.publishSourceAvatarUrl = publishSourceAvatarUrl;
    }

    public String getPublishSourceLinkUrl() {
        return publishSourceLinkUrl;
    }

    public void setPublishSourceLinkUrl(String publishSourceLinkUrl) {
        this.publishSourceLinkUrl = publishSourceLinkUrl;
    }
}
