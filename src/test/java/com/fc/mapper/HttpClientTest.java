package com.fc.mapper;

import com.fc.gson.HttpResult;
import com.fc.service.HttpClientOperateService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class HttpClientTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "application-context.xml" });
        HttpClientOperateService httpClientOperate = (HttpClientOperateService)context.getBean("HttpClientOperateService");
        Map<String,String> map = new HashMap<>();
        map.put("newstype", "3");
        map.put("location", "10");
        map.put("page", "0");
        String result = httpClientOperate.doGet("http://47.100.197.44/news/rest/news/getnewslistsubjectsbypage", map);
        System.out.println(result);
//        //无参get请求
//        String result = httpClientOperate.doGet("http://www.baidu.com");
//        System.out.println(result);
//        //有参get请求
//        Map<String,String> map = new HashMap<>();
//        map.put("waybillNo", "12341223");
//        String result2 = httpClientOperate.doGet("http://www.baidu.com", map);
//        System.out.println(result2);
//        //post请求
//        HttpResult entity = httpClientOperate.doPost("http://10.230.21.133:8180/esb2/rs/ESB_FOSS2ESB_FOSS_THE_RECEIVING_VERIFY");
//        System.out.println(entity);
//        //有参post请求
//        HttpResult entity2 = httpClientOperate.doPost("http://10.230.21.133:8180/esb2/rs/ESB_FOSS2ESB_FOSS_THE_RECEIVING_VERIFY", map);
//        System.out.println(entity2);
//        //有参post请求rest服务 JSON
//        String json = "{\"waybillNo\":\"12341223\"}";
//        HttpResult entity3 = httpClientOperate.doPostJson("http://10.230.21.133:8180/esb2/rs/ESB_FOSS2ESB_FOSS_THE_RECEIVING_VERIFY",json);
//        System.out.println(entity3);
    }
}
