package com.fc.entity;

public enum SourceEnum {
    OURSITE("oursite"),
    SPIDER("spider");

    private String desc;
    private SourceEnum(String desc) {
        this.desc = desc;
    }

    public String getSourceDesc() {
        return this.desc;
    }
}
