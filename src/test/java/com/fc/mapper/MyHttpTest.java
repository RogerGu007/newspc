package com.fc.mapper;

import com.fc.util.JerseyClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyHttpTest implements InitializingBean {

    @Autowired
    private static JerseyClient jerseyClient;

    /**
     * @autho Roger
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        //有参get请求
        Map<String,String> map = new HashMap<>();
        map.put("newstype", "3");
        map.put("location", "10");
        map.put("page", "0");
//        String result2 = httpClientOperate.doGet("http://47.100.197.44/news/rest/news/getnewslistsubjectsbypage", map);
//        System.out.println(result2);
        //post请求
//        HttpResult entity = httpClientOperate.doPost("http://10.230.21.133:8180/esb2/rs/ESB_FOSS2ESB_FOSS_THE_RECEIVING_VERIFY");
//        System.out.println(entity);
        //有参post请求
//        HttpResult entity2 = httpClientOperate.doPost("http://10.230.21.133:8180/esb2/rs/ESB_FOSS2ESB_FOSS_THE_RECEIVING_VERIFY", map);
//        System.out.println(entity2);
        //有参post请求rest服务 JSON
//        String json = "{\"waybillNo\":\"12341223\"}";
//        HttpResult entity3 = httpClientOperate.doPostJson("http://10.230.21.133:8180/esb2/rs/ESB_FOSS2ESB_FOSS_THE_RECEIVING_VERIFY",json);
//        System.out.println(entity3);
    }

    public static void main(String[] args) {
        String url = "http://47.100.197.44/news/rest/comment/addcomment";
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("newsID", "5402");
        contentMap.put("userID", "2");
        contentMap.put("comment", "test123");
//        Response response = jerseyClientBase.postHttp(url, contentMap);
//        System.out.println(response);
    }
}
