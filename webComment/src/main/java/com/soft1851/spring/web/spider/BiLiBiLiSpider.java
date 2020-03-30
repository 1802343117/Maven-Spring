package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.soft1851.spring.web.entity.Rank;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12559
 */
public class BiLiBiLiSpider {

    private static final Integer SUCCESS = 200;

    /**
     * 用 HtmlUnit爬取京东手机页面
     * */
    public static void getItems() throws Exception {
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(600 * 1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = webClient.getPage("https://list.jd.com/list.html?cat=9987,653,655");
        List<HtmlDivision> divs = page.getByXPath("//div[@id='plist']//ul//li[@class='gl-item']//div[@class='gl-wrap j-sku-item']");
        for (HtmlDivision div : divs) {
            DomNodeList<DomNode> childs = div.getChildNodes();
            String name = "";
            String price = "";
            String comments = "";
            for(DomNode dn : childs) {
                NamedNodeMap map = dn.getAttributes();
                Node node = map.getNamedItem("class");
                if (node != null) {
                    String value = node.getNodeValue();
                    if(value.contains("p-name")) {
                        name = dn.asText();
                    } else if (value.contains("p-price")) {
                        price = dn.asText();
                    } else if(value.contains("p-commit")) {
                        comments = dn.asText();
                    }
                }
            }
            System.out.println(name + "//" + price + "//" + comments);
        }
    }

    /**
     * HttpClient和JSoup爬取B站排行榜
     * */
    public static List<Rank> getRanks() {
        List<Rank> rankList = new ArrayList<>();
        // 目标地址
        String userAgentt = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Mobile Safari/537.36";
        String url = "https://www.bilibili.com/ranking?spm_id_from=333.851.b_7072696d61727950616765546162.3";
        // 创建httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            Thread.sleep(2000);
            // 创建get 对象
            HttpGet get = new HttpGet(url);
            get.setHeader("User-Agent", userAgentt);
            // 创建 context 对象
            HttpClientContext context = HttpClientContext.create();
            // 创建 response 对象
            CloseableHttpResponse response = httpClient.execute(get, context);
            System.out.println(response.getStatusLine());

            int statusCode = response.getStatusLine().getStatusCode();

            if(statusCode == SUCCESS) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String res = EntityUtils.toString(entity);
//                    System.out.println(res);
                    Document document = Jsoup.parse(res);
                    // 通过标签定位到元素集合
                    Elements elements = document.getElementsByClass("rank-item");
                    Elements scripts = document.getElementsByTag("script");
                    String wholeData = scripts.get(5).html();
                    // 查看一下有多少个标签
                    System.out.println(scripts.size());
                    String data = wholeData.substring(wholeData.indexOf("rankList") + 10, wholeData.indexOf("rankRouteParams") - 2);
                    // 查看是否已经过滤掉一些不需要的数据，只留下json数组
                    System.out.println(data);
                    JSONArray jsonArray = JSONArray.parseArray(data);
                    jsonArray.forEach(o -> {
                        JSONObject json = JSONObject.parseObject(o.toString());
                        Rank rank = Rank.builder()
                                .heroName(json.getString("title"))
                                .url(json.getString("pic"))
                                .build();
                        rankList.add(rank);
                    });
                    System.out.println(elements.size());
                    for (Element element : elements) {
                        String num = element.child(0).text();
//                        System.out.println(num);
                        Element contentEle = element.child(1);
//                        System.out.println(contentEle);
                        String title = contentEle.select(".title").text();
                        // 输出查看是否拿到了目标标题
                        System.out.println(contentEle.select(".title").text());
                        // 图片做了依赖加载,暂时未取到值
                        Elements img = contentEle.select(".lazy-img img");
//                        System.out.println(img.attr("src"));
                        String cover = img.attr("src");
                        Rank rank = Rank.builder()
                                .Id(Integer.parseInt(num))
                                .heroName(title)
                                .url(cover)
                                .build();
                        rankList.add(rank);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rankList;
    }

    public static void main(String[] args) throws Exception {
        for (Rank rank : getRanks()) {
            System.out.println(rank);
        }
//        getRanks();
//        getItems();
    }
}
