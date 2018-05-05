package com.fc.controller;

import com.fc.gson.RetFLCommentResultGson;
import com.fc.model.Topic;
import com.fc.service.ReplyService;
import com.fc.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @RequestMapping(value = "/reply.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    RetFLCommentResultGson reply(String newsid, String userid, String content){
        RetFLCommentResultGson response = replyService.reply(newsid, userid, content);
        return response;
    }

    /**
     * 二级评论 todo
     *
     * @param pid
     * @param rid
     * @param content
     * @param session
     * @return
     */
    @RequestMapping("/comment.do")
    public String comment(int pid,int rid, String content, HttpSession session){
        int sessionUid = (int) session.getAttribute("uid");
        replyService.comment(pid,sessionUid,rid,content);
        return "redirect:toPost.do?pid="+pid;
    }
}





