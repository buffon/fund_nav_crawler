package com.harry.base.crawler.pipeline;

import com.harry.base.crawler.dao.FundNavDao;
import com.harry.base.crawler.model.FundNavInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by chenyehui on 16/8/27.
 */
@Component
public class FundNavPipeline implements PageModelPipeline<FundNavInfo> {

    public Integer count = 1;

    @Autowired
    private FundNavDao fundNavDao;

    @Override
    public void process(FundNavInfo fundNavInfo, Task task) {
        if (StringUtils.isNotBlank(fundNavInfo.getCode())) {
            System.out.println(count++ + " " + fundNavInfo.toString());
        }

    }
}
