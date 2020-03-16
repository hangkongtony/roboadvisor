package com.penghk.fund.roboadvisor.service;

import com.penghk.fund.roboadvisor.entity.Index;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/16 19:29
 */
public interface IndexMonitor {

    /**
     * 获取指数每日行情
     * @param txCode 指数代码
     * @param tradeDate 交易日期 （日期格式：YYYYMMDD，下同）
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    Index getIndexDaily(String txCode, String tradeDate, String startDate, String endDate);



}
