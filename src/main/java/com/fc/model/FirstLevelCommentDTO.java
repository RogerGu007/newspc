package com.fc.model;

import org.springframework.util.StringUtils;

import java.util.List;

import static com.fc.entity.Constant.DEFAULT_AVATAR;
import static com.fc.entity.Constant.DOMAIN_HOST;

public class FirstLevelCommentDTO extends BaseDTO {
    private Long 	newsID;
    private Long	userID;
    private String nickName;
    private String avatarUrl;
    private String comment;
    private Integer count;
    private List<SecondLevelCommentDTO> secondLevelComments;

    public FirstLevelCommentDTO()
    {

    }
    public FirstLevelCommentDTO(Long newsID, Long userID, String nickName, String avatarUrl, String comment)
    {
        setNewsID(newsID);
        setUserID(userID);
        setNickName(nickName);
        setAvatarUrl(avatarUrl);
        setComment(comment);
        setCount(1);
    }

    public String getAvatarUrl() {
        if (StringUtils.isEmpty(avatarUrl)) {
            avatarUrl = DEFAULT_AVATAR;
        }

        if (!avatarUrl.contains("http")) {
            avatarUrl = String.format("http://%s/asset/%s", DOMAIN_HOST, avatarUrl);
        }
        return avatarUrl;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setNewsID(Long newsID) {
        this.newsID = newsID;
    }

    public Long getUserID() {
        return userID;
    }

    public Long getNewsID() {
        return newsID;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSecondLevelComments(List<SecondLevelCommentDTO> secondLevelComments) {
        this.secondLevelComments = secondLevelComments;
    }

    public List<SecondLevelCommentDTO> getSecondLevelComments() {
        return secondLevelComments;
    }
}