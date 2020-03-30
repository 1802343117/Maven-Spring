package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.LOL;
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
public class LOLSpider {

    private static final Integer SUCCESS = 200;

    public static List<LOL> getLoL() {
        List<LOL> lolList = new ArrayList<>();
        // 目标地址
        String url = "https://yz.lol.qq.com/v1/zh_cn/search/index.json";
        // 创建httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建get 对象
        HttpGet get = new HttpGet(url);
        // 创建 context 对象
        HttpClientContext context = HttpClientContext.create();
        // 创建 response 对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response.getStatusLine());

        // 如果请求成功，则获取网页源码
        if(response.getStatusLine().getStatusCode() == SUCCESS) {
            // 获取响应对象实体，并转成UTF-8 字符串
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(res);

            // 获取网页 json文件数据
            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONArray list = jsonObject.getJSONArray("champions");
            list.forEach(o -> {
                JSONObject json = JSONObject.parseObject(o.toString());
                LOL lol = LOL.builder()
                        .heroName(json.getString("name"))
                        .url(json.getJSONObject("image").getString("uri"))
                        .build();
                lolList.add(lol);
            });
        } else {
            System.out.println("请求失败");
        }
        try {
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lolList;
    }

    public static void main(String[] args) {
        for (LOL lol : getLoL()) {
            System.out.println(lol);
        }
//        System.out.println(getLoL());
//        getLoL();
    }
}
