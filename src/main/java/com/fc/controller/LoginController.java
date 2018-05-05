package com.fc.controller;


import com.fc.gson.LoginRegisterGson;
import com.fc.gson.RetResultGson;
import com.fc.model.User;
import com.fc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.fc.entity.RetCode.RET_CODE_OK;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;


    /**
     * 去注册和登录的页面
     * @return
     */
    @RequestMapping("/toLogin.do")
    public String toLogin(){
        return "login";
    }

    /**
     * 注册
     * @param user
     * @param repassword
     * @param model
     * @return
     */
    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public String register(User user, String repassword, Model model){
        String result = loginService.register(user,repassword);
        if(result.equals("ok")){
            model.addAttribute("info","系统已经向你的邮箱发送了一封邮件哦，验证后就可以登录啦~");
            return "prompt/promptInfo";
        }else {
            model.addAttribute("register","yes");
            model.addAttribute("email",user.getEmail());
            model.addAttribute("error",result);
            return "login";
        }
    }

    /**
     * 激活
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = "/activate.do")
    public String activate(String code,Model model){
        loginService.activate(code);

        model.addAttribute("info","您的账户已经激活成功，可以去登录啦~");
        return "prompt/promptInfo";
    }

    /**
     * 注销
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout.do",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("uid");
        return "redirect:listTopic.do";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
//    public String login(String user, Model model, HttpSession session){
    LoginRegisterGson login(String phoneno, String smscode){
//    RetResultGson login(HttpSession session){
//        Map<String,Object> map = loginService.login(user);
//        if(map.get("status").equals("yes")){
//            session.setAttribute("uid",map.get("uid"));
//            session.setAttribute("headUrl",map.get("headUrl"));
//            return "redirect:toMyProfile.do";
//        }else {
//            model.addAttribute("email",user.getEmail());
//            model.addAttribute("error",map.get("error"));
//            return "login";
//        }
//        String cookiename = cookie.getName();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher m = pattern.matcher(phoneno);
        if (m.find())
            phoneno = m.group();

        m = pattern.matcher(smscode);
        if (m.find())
            smscode = m.group();

        LoginRegisterGson retResultGson = loginService.login(phoneno, smscode);
        return retResultGson;
//        if (retResultGson.getRetCode() == RET_CODE_OK)
//            return "redirect:listTopic.do";
//        else
//            return "redirect:toLogin.do";
    }

    @RequestMapping(value = "/getsmscode.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    RetResultGson getSmsCode(String phoneno) {
        RetResultGson msg = loginService.getSmsCode(phoneno);
        return msg;
    }
}


