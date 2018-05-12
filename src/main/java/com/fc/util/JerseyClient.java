package com.fc.util;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.fc.gson.CommentListRequestGson;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class JerseyClient {

    private String acceptedResponseMediaTypes = MediaType.APPLICATION_JSON;

    private String entityConverteMediaType = MediaType.APPLICATION_JSON;

    private static String NEWS_REMOTE_ADDRESS = "http://47.100.197.44/news/rest";

    public String getHttp(String url){
        checkinitSuccessGet();
        WebTarget target = ClientBuilder.newClient().target(NEWS_REMOTE_ADDRESS + url);
        Response rawResponse = target.request(acceptedResponseMediaTypes).get();
        return rawResponse.readEntity(String.class);
    }

    public String getHttp(String url, Map<String, String> paramMap){
        checkinitSuccessGet();
        WebTarget target = ClientBuilder.newClient().target(NEWS_REMOTE_ADDRESS + url);
        for (Map.Entry<String, String> kv : paramMap.entrySet()) {
            target = target.queryParam(kv.getKey(), kv.getValue());
        }
        Response rawResponse = target.request(acceptedResponseMediaTypes).get();
        return rawResponse.readEntity(String.class);
    }

    public String getHttp(String url, Object obj){
        checkinitSuccessGet();
        WebTarget target = ClientBuilder.newClient().target(NEWS_REMOTE_ADDRESS + url);
        Map<String, Object> paramMap = getKeyAndValue(obj);
        for (Map.Entry<String, Object> kv : paramMap.entrySet()) {
            target = target.queryParam(kv.getKey(), kv.getValue().toString());
        }
        Response rawResponse = target.request(acceptedResponseMediaTypes).get();
        return rawResponse.readEntity(String.class);
    }

    public String postHttp(String url, Map<String, String> paramMap){
        checkinitSuccessPost();
        MultivaluedMap<String, String> contentMap = new MultivaluedHashMap<>();
        for (Map.Entry<String, String> kv : paramMap.entrySet()) {
            contentMap.add(kv.getKey(), kv.getValue().toString());
        }
        Response rawResponse = ClientBuilder.newClient().target(NEWS_REMOTE_ADDRESS + url).request(entityConverteMediaType)
                .post(Entity.form(contentMap));
        return rawResponse.readEntity(String.class);
    }

    public String postHttp(String url, Object obj){
        checkinitSuccessPost();
        Map<String, Object> paramMap = getKeyAndValue(obj);
        MultivaluedMap<String, String> contentMap = new MultivaluedHashMap<>();
        for (Map.Entry<String, Object> kv : paramMap.entrySet()) {
            contentMap.add(kv.getKey(), kv.getValue().toString());
        }
        Response rawResponse = ClientBuilder.newClient().target(NEWS_REMOTE_ADDRESS + url).request(entityConverteMediaType)
                .post(Entity.form(contentMap));
        return rawResponse.readEntity(String.class);
    }

    private void checkinitSuccessPost(){
        if (entityConverteMediaType == null||acceptedResponseMediaTypes == null) {
            System.out.println("JerseyClientUtil init faild when POST! please init entityConverteMediaType and acceptedResponseMediaTypes!");
            return;
        }
    }

    private void checkinitSuccessGet(){
        if (acceptedResponseMediaTypes == null) {
            System.out.println("JerseyClientUtil init faild when GET! please init acceptedResponseMediaTypes!");
            return;
        }
    }

    public Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            Object val = new Object();
            try {
                val = f.get(obj);
                // 得到此属性的值
                map.put(f.getName(), val);// 设置键值
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * test
     */
    public static void main(String[] args) {
        String url = "http://47.100.197.44/news/rest/comment/addcomment";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        CommentListRequestGson commentListRequestGson = CommentListRequestGson.buildReq("5542", "108", "213213");
        MultivaluedMap<String, String> contentMap = new MultivaluedHashMap<>();
        contentMap.add("newsID", "5542");
        contentMap.add("userID", "108");
        contentMap.add("comment", "哈哈哈");
        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.form(contentMap));
        response.close();

//        WebTarget target2 = client.target("http://47.100.197.44/news/rest/news/getnewsdetail");
//        Response response = target2.queryParam("newsid", "5542")
//                .request(MediaType.APPLICATION_JSON).get();
//        response.close();
    }
}