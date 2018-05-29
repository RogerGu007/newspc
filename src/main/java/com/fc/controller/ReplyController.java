package com.fc.controller;

import com.fc.gson.RetFLCommentResultGson;
import com.fc.gson.RetSecCommentResultGson;
import com.fc.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    /**
     * 一级评论
     *
     * @param newsid
     * @param userid
     * @param content
     * @return
     */
    @RequestMapping(value = "/reply.do", produces = "application/json;charset=utf-8")
    public @ResponseBody
    RetFLCommentResultGson reply(String newsid, String userid, String content){
        RetFLCommentResultGson response = replyService.reply(newsid, userid, content);
        return response;
    }

    /**
     * 二级评论
     *
     * @param newsid
     * @param rid
     * @param fromuserid
     * @param touserid
     * @param content
     * @return
     */
    @RequestMapping(value = "/comment.do", produces = "application/json;charset=utf-8")
    public @ResponseBody
    RetSecCommentResultGson comment(String newsid, String rid, String fromuserid, String touserid, String content){
        RetSecCommentResultGson resultGson = replyService.secondReply(rid, fromuserid, touserid, content);
        return resultGson;
    }
}





