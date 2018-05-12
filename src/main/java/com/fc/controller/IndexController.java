package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * 去主页
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/toIndex.do")
    public String toIndex(Model model, HttpServletRequest request){
        return "listTopic";
    }
}
