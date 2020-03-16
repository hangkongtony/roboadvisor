package com.penghk.fund.roboadvisor.service.impl;

import com.penghk.fund.roboadvisor.entity.Index;
import com.penghk.fund.roboadvisor.service.IndexMonitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/16 19:34
 */

@Slf4j
@Service
public class IndexMonitorImpl implements IndexMonitor {

    @Override
    public Index getIndexDaily(String txCode, String tradeDate, String startDate, String endDate) {
        return null;
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void getIndexDaily() {

        String txCode = "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String nowDate = simpleDateFormat.format(new Date());

        Index index = getIndexDaily(txCode, nowDate, null, null);

        log.info(index.toString());

    }

}
