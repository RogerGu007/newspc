package com.fc.controller;

import com.fc.model.UserDTO;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class DownloadController {

    @Autowired
    private UserService userService;

    //去be编辑页面
    @RequestMapping(value = "/download.do", produces = "application/json;charset=utf-8")
    public String download(Model model) {
        List<UserDTO> hotUserList = userService.listUserByHot();
        model.addAttribute("hotUserList", hotUserList);
        return "download";
    }
}
