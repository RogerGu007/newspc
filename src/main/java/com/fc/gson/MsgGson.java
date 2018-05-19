package com.fc.gson;

import java.sql.Timestamp;
import java.util.List;

public class MsgGson {
    private String		ID;
    private String 	content;
    private List<String> imagePaths;
    private Integer	newsType;
    private Integer	newsSubType;
    private Integer    locationCode;	//地点，可以更加学校所在地填写
    private Timestamp postDate;	//post的时间
    private Boolean 	isHot;
    private Boolean 	isValid;
    private Long 		publisherId;
    private Boolean	hasDetail;//是否有详细内容

    private Timestamp  updateAt;
    private String		updateBy;
    private Timestamp	createAt;
    private String		createBy;

    private String     publishSource;

    private Integer	commentCount;
    private String publishSourceAvatarUrl;
    private String publishSourceLinkUrl;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public Integer getNewsSubType() {
        return newsSubType;
    }

    public void setNewsSubType(Integer newsSubType) {
        this.newsSubType = newsSubType;
    }

    public void setLocationCode(Integer locationCode) {
        this.locationCode = locationCode;
    }

    public Integer getLocationCode() {
        return locationCode;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Boolean getValid() {
        return isValid;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setPublishSource(String publishSource) {
        this.publishSource = publishSource;
    }

    public String getPublishSource() {
        return publishSource;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Boolean getHasDetail() {
        return hasDetail;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setHasDetail(Boolean hasDetail) {
        this.hasDetail = hasDetail;
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
