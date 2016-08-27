package com.harry.base.crawler.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by chenyehui on 16/8/27.
 */
@TargetUrl("http://finance.sina.com.cn/fund/quotes/\\w+/bc.shtml")
public class FundNavInfo implements AfterExtractor {

    @ExtractBy(value = "span[@class='fund_data']/text()")
    private String data;

    @ExtractBy(value = "//div[@class='fund_name_code']/h1[@class='fund_name']/text()")
    private String name;

    @ExtractBy(value = "//div[@class='fund_name_code']/span[@class='fund_code']/text()")
    private String code;

    @ExtractBy(value = "table[@class='fund_lsjz_table']/thead/tr/td/text()")
    private String date;

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        try {
            String date1 = date.substring(7);
            date = date1.substring(0, date1.length() - 1);
        } catch (Exception e) {
            data = null;
        }
        return "FundNavInfo{" +
                "data='" + data + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code.substring(1, code.length() - 1) + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public void afterProcess(Page page) {

    }

    public static void main(String[] args) {
        String s = "日期区间（截止2016-08-26）";
        String s1 = s.substring(7);

        System.out.println(s1.substring(0, s1.length() - 1));
    }
}
