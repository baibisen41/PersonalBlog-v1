package com.bbs.personalblog.Task;

import com.bbs.personalblog.common.Common;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by 大森 on 2017/12/10.
 */
@Component
public class SpiderTask {

    private Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).timeout(10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public void startSpiderHandler() {

        //获取全部文章 共计3000条，下一页根据规律仿写url
/*        for (int i = 1; i <= 100; i++) {
            if (i == 1) {
                Document document = getDocument(Common.newsUrl);
                Elements elements = document.getElementsByClass("news_entry");
                for (Element element : elements) {
                    System.out.println("标题：" + element.text() + "\n");
                }
            } else {
                Document document = getDocument(Common.newsUrl + "/n/page/" + i + "/");
                Elements elements = document.getElementsByClass("news_entry");
                for (Element element : elements) {
                    System.out.println("标题：" + element.text() + "\n");
                }
            }
        }*/

        Document document = getDocument(Common.newsUrl);

        //标题
        Elements elements = document.getElementsByClass("news_entry");
        for (Element element : elements) {
            System.out.println("标题：" + element.text() + "\n");
        }

        //内容概述
        Elements elements1 = document.getElementsByClass("entry_summary");
        for (Element element : elements1) {
            System.out.println("概述：" + element.text() + "\n");
        }

        //内容详情
        Elements elements0 = document.select("div.content").select("h2");
        for (Element element : elements0) {
            String urls = element.getElementsByTag("a").attr("href");
//            System.out.println("url:" + urls);
            Document document1 = getDocument(Common.newsUrl + urls);
            Elements elements2 = document1.select("#news_body").select("p");
            System.out.println("内容：" + elements2.text() + "\n");
        }

    }

    private int saveContentHandler() {
        int saveResultCode = 0;
        return saveResultCode;
    }

    public static void main(String[] args) {
        new SpiderTask().startSpiderHandler();
    }

}
