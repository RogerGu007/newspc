package com.fc.model;

public class TopicDTO {

    private Integer tid;
    //名称
    private String name;
    //描述
    private String content;
    //图片
    private String image;

    public TopicDTO() {}

    public TopicDTO(Integer tid) {
        this.tid = tid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TopicDTO{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public static TopicDTO buildTopic(String name, String content, String image) {
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setName(name);
        topicDTO.setContent(content);
        topicDTO.setImage(image);
        return topicDTO;
    }
}
