package com.harry.base.crawler;

import com.harry.base.crawler.model.FundNavInfo;
import com.harry.base.crawler.pipeline.FundNavPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

/**
 * Created by chenyehui on 16/8/27.
 */
@Component
public class FundNavCrawler {

    @Autowired
    private FundNavPipeline fundNavPipeline;

    public void crawler() {
        OOSpider.create(Site.me(), fundNavPipeline, FundNavInfo.class).addUrl("http://finance.sina.com.cn/fund/quotes/001315/bc.shtml").thread(30).run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        FundNavCrawler fundNavCrawler = applicationContext.getBean(FundNavCrawler.class);
        fundNavCrawler.crawler();
    }
}
