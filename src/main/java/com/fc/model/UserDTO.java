package com.fc.model;


public class UserDTO {

    private Integer uid;

    //用户属性
    private String username;
    private String headUrl;
    private String school;
    private String linkUrl;

    public UserDTO() {}

    public UserDTO(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public static UserDTO buildUserDto(Integer uid, String username, String headUrl, String linkUrl) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUid(uid);
        userDTO.setUsername(username);
        userDTO.setHeadUrl(headUrl);
        userDTO.setLinkUrl(linkUrl);
        return userDTO;
    }
}
