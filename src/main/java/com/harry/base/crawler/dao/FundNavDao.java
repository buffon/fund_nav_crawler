package com.harry.base.crawler.dao;

import com.harry.base.crawler.model.FundNavInfo;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by chenyehui on 16/8/27.
 */
public interface FundNavDao {

    @Insert("insert into fund_nav(name,code,nav,date) values(#{name}, #{code}, #{nav}, #{date})")
    int insert(FundNavInfo info);
}
