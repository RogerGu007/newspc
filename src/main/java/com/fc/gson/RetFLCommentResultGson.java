package com.fc.gson;


import com.fc.model.FirstLevelCommentDTO;

public class RetFLCommentResultGson extends RetResultGson {
    private FirstLevelCommentDTO firstLevelCommentDTO;

    public RetFLCommentResultGson(int retCode, String message)
    {
        super(retCode, message);
    }

    public void setFirstLevelCommentDTO(FirstLevelCommentDTO firstLevelCommentDTO) {
        this.firstLevelCommentDTO = firstLevelCommentDTO;
    }

    public FirstLevelCommentDTO getFirstLevelCommentDTO() {
        return firstLevelCommentDTO;
    }
}