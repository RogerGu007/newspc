package com.fc.controller;

import com.fc.gson.MsgGson;
import com.fc.gson.NewsSubjectResultGson;
import com.fc.model.*;
import com.fc.service.PostService;
import com.fc.service.ReplyService;
import com.fc.service.TopicService;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private ReplyService replyService;


    //去发帖的页面
    @RequestMapping("/toPublish.do")
    public String toPublish(Model model){
        List<TopicDTO> topicDTOList = topicService.listTopic();
        model.addAttribute("topicList", topicDTOList);
        return "publish";
    }

    //发帖
//    @RequestMapping("/publishPost.do")
//    public String publishPost(Post post) {
//        int id = postService.publishPost(post);
//        return "redirect:toPost.do?pid="+id;
//    }

    //按时间，倒序，列出帖子
    @RequestMapping("/listPostByTime.do")
    public String listPostByTime(int location, int newsType, int curPage, int subNewsType, Model model){
        if (StringUtils.isEmpty(String.valueOf(location)))
            location = 21;
        if (StringUtils.isEmpty(String.valueOf(newsType)))
            newsType = 2;
        if (StringUtils.isEmpty(String.valueOf(curPage)))
            curPage = 1;
        if (StringUtils.isEmpty(String.valueOf(subNewsType)))
            subNewsType = 0;
//        PageBean<Post> pageBean = postService.listPostByTime(curPage);
        PageBean<MsgGson> pageBean = postService.listPostByTime(location, newsType, subNewsType, curPage);
        List<UserDTO> userList = userService.listUserByTime();
        List<UserDTO> hotUserList = userService.listUserByHot();
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("userList", userList);
        model.addAttribute("hotUserList", hotUserList);
        return "index";
    }

    //去帖子详情页面
    @RequestMapping(value = "/toPost.do", produces = "application/json;charset=utf-8")
    public String toPost(Long newsid, Model model, HttpSession session){
        //获取帖子信息
        NewsDetailDTO newsDetailDTO = postService.getPostDetail(newsid);
        //获取评论信息
        List<FirstLevelCommentDTO> replyList = replyService.listReply(newsid, 0);
        //判断用户是否已经点赞
        boolean liked = false;
        //向模型中添加数据
        model.addAttribute("newsdetail", newsDetailDTO);
        model.addAttribute("replyList", replyList);
        model.addAttribute("liked",liked);
        return "post";
    }

    //获取帖子详情
    @RequestMapping(value = "/getNewsDetail.do", produces = "application/json;charset=utf-8")
    public @ResponseBody
    NewsDetailDTO getNewsDetail(Long newsid){
        //获取帖子信息
        NewsDetailDTO newsDetailDTO = postService.getPostDetail(newsid);
        //向模型中添加数据
        return newsDetailDTO;
    }
}
