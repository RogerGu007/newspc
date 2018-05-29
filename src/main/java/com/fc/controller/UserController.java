package com.fc.controller;

import com.fc.gson.MsgGson;
import com.fc.gson.NewsFavoriteResultGson;
import com.fc.gson.RetResultGson;
import com.fc.gson.UserInfoGson;
import com.fc.model.NewsDTO;
import com.fc.service.PostService;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.fc.entity.RetCode.RET_CODE_OK;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    /**
     * 查看我的个人主页
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/toMyProfile.do")
    public String toMyProfile(String userid, HttpSession session, Model model) {
        UserInfoGson user = userService.getProfile(userid);
        //查询发帖、收藏纪录
//        List<Post> postList =  postService.getPostList(userid);
        List<MsgGson> favourList = postService.getFavourNewsList(userid);
        model.addAttribute("user", user);
        model.addAttribute("favourList",favourList);
        return "myProfile";
    }

    /**
     * 去编辑信息的页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/toEditProfile.do")
    public String toEditProfile(String userid, HttpSession session,Model model){
//        int uid = (int) session.getAttribute("uid");
        UserInfoGson user = userService.getProfile(userid);
        model.addAttribute("user",user);
        return "editProfile";
    }

    /**
     * 编辑信息
     * @param user
     * @return
     */
    @RequestMapping("/editProfile.do")
    public String editProfile(UserInfoGson user){
        userService.updateUser(user);
        return "redirect:toMyProfile.do?userid=" + user.getID();
    }

    /**
     * 查看我的收藏
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/MyFavourite.do")
    public String MyFavourite(String userid, HttpSession session, Model model) {
        UserInfoGson user = userService.getProfile(userid);
        //查询收藏纪录
        List<MsgGson> favourList = postService.getFavourNewsList(userid);
        model.addAttribute("user", user);
        model.addAttribute("favourList",favourList);
        return "myFavourite";
    }

    @RequestMapping("/afterForgetPassword.do")
    public String afterForgetPassword(){
        return "prompt/afterForgetPassword";
    }


    @RequestMapping("/updateHeadUrl.do")
//    public String updateHeadUrl(String userid, MultipartFile myFileName, Model model, HttpSession session) throws IOException {
    public String updateHeadUrl(String userid, String avatarurl, Model model, HttpSession session) {
        // 文件类型限制
//        String[] allowedType = {"image/bmp", "image/gif", "image/jpeg", "image/png"};
//        boolean allowed = Arrays.asList(allowedType).contains(myFileName.getContentType());
////        if (!allowed) {
////            model.addAttribute("error3","图片格式仅限bmp，jpg，png，gif~");
////            return "editProfile";
////        }
////        // 图片大小限制
////        if (myFileName.getSize() > 3 * 1024 * 1024) {
////            model.addAttribute("error3","图片大小限制在3M以下哦~");
////            return "editProfile";
////        }
//        // 包含原始文件名的字符串
//        String fi = myFileName.getOriginalFilename();
//        // 提取文件拓展名
//        String fileNameExtension = fi.substring(fi.indexOf("."), fi.length());
//        // 生成云端的真实文件名
//        String remoteFileName = UUID.randomUUID().toString() + fileNameExtension;
//        qiniuService.upload(myFileName.getBytes(), remoteFileName);

        //更新头像URL
        RetResultGson resultGson = userService.updateHeadUrl(userid, avatarurl);
        if (resultGson.getRetCode() != RET_CODE_OK) {
            model.addAttribute("error", "用户头像更新失败！");
            return "redirect:toEditProfile.do?userid=" + userid;
        }
        return "redirect:toMyProfile.do?userid=" + userid;
    }
}

