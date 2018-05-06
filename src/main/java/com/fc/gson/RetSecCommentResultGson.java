package com.fc.gson;

import com.fc.model.SecondLevelCommentDTO;

public class RetSecCommentResultGson extends RetResultGson {
    private SecondLevelCommentDTO secondLevelCommentDTO;
    public RetSecCommentResultGson(int retCode, String message)
    {
        super(retCode, message);
    }

    public SecondLevelCommentDTO getSecondLevelCommentDTO() {
        return secondLevelCommentDTO;
    }

    public void setSecondLevelCommentDTO(SecondLevelCommentDTO secondLevelCommentDTO) {
        this.secondLevelCommentDTO = secondLevelCommentDTO;
    }
}