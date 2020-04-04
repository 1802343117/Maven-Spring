package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Music;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12559
 */
public class TextSpider {

    private static final Integer SUCCESS = 200;

    public static void main(String[] args) {
        getContent();
    }

    public static List<Music> getContent(){
        List<Music> musicList = new ArrayList<>();
        //网易云音乐链接
        String[] allUrl = {"https://music.163.com/m/discover/toplist?id=991319590",
                "https://music.163.com/m/discover/toplist",
//                "https://music.163.com/m/discover/toplist?id=3779629",
//                "https://music.163.com/m/discover/toplist?id=2884035",
//                "https://music.163.com/discover/toplist?id=3778678",
//                "https://music.163.com/discover/toplist?id=1978921795",
//                "https://music.163.com/discover/toplist?id=991319590",
//                "https://music.163.com/discover/toplist?id=2250011882",
//                "https://music.163.com/discover/toplist?id=2617766278",
//                "https://music.163.com/discover/toplist?id=71385702",
//                "https://music.163.com/discover/toplist?id=2006508653",
//                "https://music.163.com/discover/toplist?id=180106",
//                "https://music.163.com/discover/toplist?id=60198",
//                "https://music.163.com/discover/toplist?id=3812895",
//                "https://music.163.com/discover/toplist?id=11641012",
//                "https://music.163.com/discover/toplist?id=60131",
//                "https://music.163.com/discover/toplist?id=120001"
        };
        for(int n=0;n<allUrl.length;n++){
            String url = allUrl[n];
            //网易云音乐链接请求头
            String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.162 Mobile Safari/537.36";
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            //设置请求头
            httpPost.setHeader("User-Agent", userAgent);
            HttpClientContext context = HttpClientContext.create();
            try {
                CloseableHttpResponse response = httpClient.execute(httpPost, context);
                int statusCode = response.getStatusLine().getStatusCode();
                if(statusCode==SUCCESS){
                    HttpEntity entity = response.getEntity();
                    String res= null;
                    res = EntityUtils.toString(entity, "UTF-8");
                    Document document = Jsoup.parse(res);
                    Elements elements = document.getElementsByClass("m-sglst");
                    for(Element element :elements){
                        for(int i=0;i<element.childNodeSize();i++){
                            //获取每首音乐的id
                            String musicId =element.child(i).attr("href").replace("//music.163.com/m/song?id=","");
                            //获取每首音乐的名字
                            String musicName = element.child(i).child(1).child(0).getElementsByClass("f-thide sgtl").text();
                            //获取每首音乐的作者
                            String author =element.child(i).child(1).child(0).getElementsByClass("f-thide sginfo").text();
                            //获取MKOnlinePlayer的对应json链接
                            String musicUrl = "http://music.uixsj.cn/api.php?callback=jQuery1113034466587161790607_1585798563762&types=url&id="+musicId+"&source=netease";
                            //获取音乐的下载链接
                            String downloadUrl=getUrl(musicUrl);
                            System.out.println(downloadUrl);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return musicList;
    }

    public static String getUrl(String url){
        HttpGet get = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response.getStatusLine().getStatusCode()==SUCCESS){
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[]  str=res.replace(")","(").split("\\(");
            String jsonContent = str[1];
            JSONObject jsonObject = JSONObject.parseObject(jsonContent);
            return jsonObject.get("url").toString();
        }
        System.out.println("获取失败");
        return null;
    }
}
