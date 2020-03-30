package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12559
 */
public class JueJinSpider {

    private static final Integer SUCCESS = 200;

    public static List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        // 目标地址
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7d71f46fb9a03c5c5a753b&device_id=1585279477030&token=eyJhY2Nlc3NfdG9rZW4iOiJ3M3ZETzFCdWJEeFJMY3pYIiwicmVmcmVzaF90b2tlbiI6ImZpZWx2QWxQTEQ5QUlQcE0iLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        // 创建httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建get 对象
        HttpGet get = new HttpGet(url);
        // 创建 context 对象
        HttpClientContext context = HttpClientContext.create();
        // 创建response 对象
        CloseableHttpResponse ch = null;
        try {
            ch = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        assert ch != null;
        System.out.println(ch.getStatusLine());

        // 如果请求成功，则获取网页源码
        if (ch.getStatusLine().getStatusCode() == SUCCESS) {
            // 获取响应对象实体，并转成UTF-8 字符串
            HttpEntity entity = ch.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

//            System.out.println(res);

            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
            list.forEach(o -> {
                JSONObject json = JSONObject.parseObject(o.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId"))
                        .topicName(json.getString("title"))
                        .topicIcon(json.getString("icon"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followersCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
//                System.out.println(topic);
                topics.add(topic);
            });
        } else {
            System.out.println("请求失败");
        }
        try {
            ch.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topics;
    }

    public static void main(String[] args) throws IOException {
        getTopics();
    }
}
