package com.hehaoyisheng.zc.main;

import com.google.common.collect.Lists;
import com.hehaoyisheng.zc.data.BaseData;
import com.hehaoyisheng.zc.entity.Odds;
import com.hehaoyisheng.zc.utils.HttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class GetData {

    public static List<String> getIndexData(String url){
        String html =  HttpClientUtil.sendHttpGet(url);
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("OddsLink");
        List<String> list = Lists.newArrayList();
        for(Element e : elements){
            list.add(e.attr("href"));
        }
        return list;
    }

    public static List<String> getOList(String url){
        String html =  HttpClientUtil.sendHttpGet(url);
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("BrownRedL");
        List<String> list = Lists.newArrayList();
        for(Element e : elements){
            String add = e.attr("href");
            if(add.endsWith("odds/")){
                list.add(add);
                System.out.println(add.split("/")[3]);
            }
        }
        return list;
    }

    public static void getInfo(String url){
        String html =  HttpClientUtil.sendHttpGet(url, "gbk");
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("qpai_q");
        if(elements.size() < 2){
            return;
        }
        //主队排名
        String rank1 = elements.get(0).text().replace("[", "").replace("]", "");
        String rank2 = elements.get(1).text().replace("[", "").replace("]", "");
        String name1 = document.getElementsByClass("qpai_zi").text();
        String name2 = document.getElementsByClass("qpai_zi_1").text();
        String lun = document.getElementsByClass("qk_two").text();
        String shuj = document.getElementsByClass("shuj").text();
        System.out.println(name1 + "[" + rank1 + "]" + " VS " + name2 + "[" + rank2 + "]");
        System.out.println(lun);
        System.out.println(shuj);

        //获取赔率
        List<Odds> list = Lists.newArrayList();
        String html1 =  HttpClientUtil.sendHttpGet(url + "ajax/?page=0&trnum=0&companytype=BaijiaBooks&type=0");
        Document document1 = Jsoup.parse(html1);
        String pei = document1.text();
        for(String s : pei.split("   ")){
            String[] ss = s.split(" ");
            ss[5] = ss[5].replace("↓", "").replace("↑", "");
            ss[6] = ss[6].replace("↓", "").replace("↑", "");
            ss[7] = ss[7].replace("↓", "").replace("↑", "");
            if(BaseData.map.get(ss[1]) != null){
                Odds odds = new Odds();
                odds.setNumber(Integer.valueOf("954510"));
                odds.setName(ss[1]);
                odds.setIndex(Double.valueOf(ss[5]));
                odds.setPing(Double.valueOf(ss[6]));
                odds.setKe(Double.valueOf(ss[7]));
                list.add(odds);
            }
            System.out.println(ss[1] + " " + ss[5] + " " + ss[6] + " " + ss[7]);
        }
        /*
        for(Element e : document1.getAllElements()){
            System.out.println(e);
        }
        */
    }

    public static void main(String[] args) {
        /*
        List<String> list = getIndexData("http://www.okooo.com/soccer/league/17/");
        for(String s : list){
            getOList("http://www.okooo.com" + s);
        }
        */
                getInfo("http://www.okooo.com/soccer/match/954510/odds/");


    }
}
