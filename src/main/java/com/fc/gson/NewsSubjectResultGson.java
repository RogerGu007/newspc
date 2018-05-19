package com.fc.gson;

import com.fc.model.NewsDTO;

import java.util.List;

public class NewsSubjectResultGson extends RetResultGson {
    private List<MsgGson> msgGsonList;

    public NewsSubjectResultGson(int retCode, String message)
    {
        super(retCode, message);
    }
    public void setMsgGsonList(List<MsgGson> msgGsonList) {
        this.msgGsonList = msgGsonList;
    }

    public List<MsgGson> getMsgGsonList() {
        return msgGsonList;
    }
}
