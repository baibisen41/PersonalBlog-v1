package com.bbs.personalblog.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by 大森 on 2017/11/28.
 */
public class SpiderUtil {

    ////后期重构

    private Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).timeout(10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    private void getContentHandler(String uriPath) {
        Document document = getDocument(uriPath);

        Elements elements2 = document.getElementsByClass("meta-title");
        System.out.println("总共：" + elements2.size() + "篇\n");
        for (Element element : elements2) {
            System.out.println("文章标题：" + element.text());
        }

        Elements elements1 = document.getElementsByClass("excerpt");
        for (Element element : elements1) {
            System.out.println("文章描述：" + element.text());
        }

        Elements elements3 = document.getElementsByClass("meta-title");
        for (Element element : elements3) {
            String url = element.getElementsByTag("a").attr("abs:href");
            System.out.println("文章链接：" + url);

            //读取该链接页面内信息
            Document document1 = getDocument(url);
            Elements elements = document1.getElementsByClass("copyright-area");
            Elements origin = elements.select("a");
            System.out.println("该文章出处：" + origin.text());

            String url4 = elements.get(0).getElementsByTag("a").attr("href");
            System.out.println("该文章出处链接：" + url4 + "\n");
        }
    }

    public static void main(String[] args) {
        String uriPath = "http://www.importnew.com/cat/news";
        new SpiderUtil().getContentHandler(uriPath);
    }
}
