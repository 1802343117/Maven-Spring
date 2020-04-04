package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Music;
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
public class MusicSpider {

    private static final Integer SUCCESS = 200;

    /**
     * HttpClient和JSoup爬取B站排行榜
     * */
    public static List<Music> musicSpider() {
        List<Music> musicList = new ArrayList<>();

        // 指定的歌手ID
        String []singer =  {"7219", "939088", "12138269", "44266", "13193", "7763", "11127"};
//        String []singer =  {"939088"};
        // 动态接口
        String url = "https://api.imjad.cn/cloudmusic/?type=artist&id=";

        for(int i = 0; i < singer.length; i++) {
            // 拼接目标地址
            String Jsurl = url + singer[i];
            System.out.println(Jsurl);

            // 创建httpclient 对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // 创建get 对象
            HttpGet get = new HttpGet(Jsurl);
            // 创建 context 对象
            HttpClientContext context = HttpClientContext.create();
            // 创建 response 对象
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(get, context);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 查看模拟发送请求是否成功
//            System.out.println(response.getStatusLine());

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

                // 获取网页 json文件数据
                JSONObject jsonObject = JSONObject.parseObject(res);
                JSONArray list = jsonObject.getJSONArray("hotSongs");
                String singerName = jsonObject.getJSONObject("artist").getString("name");
                System.out.println(singerName);
                list.forEach(o -> {
                    JSONObject json = JSONObject.parseObject(o.toString());
                    // 创建 Music 对象
                    Music music = new Music();
                    music.setTitle(json.getJSONObject("al").getString("name"));
                    music.setSinger(singerName);
                    music.setCover(json.getJSONObject("al").getString("picUrl"));

                    // 通过 ID 获取音乐连接
                    String musicurl = "https://api.imjad.cn/cloudmusic/?type=song&id=";

                    // 创建httpclient 对象
                    CloseableHttpClient httpClientMusic = HttpClients.createDefault();
                    // 创建get 对象
                    HttpGet getMusic = new HttpGet(musicurl + json.getJSONObject("privilege").getString("id"));
                    System.out.println(getMusic);

                    // 创建 context 对象
                    HttpClientContext contextMusic = HttpClientContext.create();

                    // 创建 response 对象
                    CloseableHttpResponse responseMusic = null;
                    try {
                        responseMusic = httpClientMusic.execute(getMusic, contextMusic);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("请求头：" + responseMusic.getStatusLine());


                    // 如果请求成功，则获取网页源码
                    if(responseMusic.getStatusLine().getStatusCode() == SUCCESS) {
                        System.out.println("请求成功");
                        // 获取响应对象实体，并转成UTF-8 字符串
                        HttpEntity entity1 = responseMusic.getEntity();
                        String res1 = null;
                        try {
                            res1 = EntityUtils.toString(entity1, "UTF-8");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("转码成功：" + res1);

                        // 获取网页 json文件数据
                        JSONObject jsonObject1 = JSONObject.parseObject(res1);
                        JSONArray list1 = jsonObject1.getJSONArray("data");
                        System.out.println(list1);
                        list1.forEach(o1 -> {
                            JSONObject json1 = JSONObject.parseObject(o1.toString());
                            music.setUrl(json1.getString("url"));
                        });
                        // 将歌曲添加到 musicList
                        musicList.add(music);
                    } else {
                        System.out.println("请求音乐链接失败");
                    }
                    try {
                        responseMusic.close();
                        httpClientMusic.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            } else {
                System.out.println("请求歌手信息失败");
            }
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return musicList;
    }

    public static void main(String[] args) throws Exception {
//        getMusics();
        // 指定的歌手ID
//        String []singer = {"1197168","939088","44266","6452","12138269","7763","11127","5781","1045123","1047337"};
        for (Music music : musicSpider()) {
            System.out.println(music);
        }
    }
}
