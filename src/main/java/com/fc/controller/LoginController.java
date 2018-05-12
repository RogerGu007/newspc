package com.fc.controller;


import com.fc.gson.LoginRegisterGson;
import com.fc.gson.RetResultGson;
import com.fc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     * 注销
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout.do",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:listTopic.do";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    LoginRegisterGson login(String phoneno, String smscode){
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


