package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DownloadController {

    //去be编辑页面
    @RequestMapping(value = "/download.do", produces = "application/json;charset=utf-8")
    public String download() {
        return "download";
    }
}
