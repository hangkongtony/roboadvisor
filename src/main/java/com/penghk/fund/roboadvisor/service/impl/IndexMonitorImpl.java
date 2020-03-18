package com.penghk.fund.roboadvisor.service.impl;

import com.alibaba.fastjson.JSON;
import com.penghk.fund.roboadvisor.entity.IndexDaily;
import com.penghk.fund.roboadvisor.entity.IndexRequest;
import com.penghk.fund.roboadvisor.entity.Request;
import com.penghk.fund.roboadvisor.enums.TsCodeEnum;
import com.penghk.fund.roboadvisor.service.IndexMonitor;
import com.penghk.fund.roboadvisor.util.TushareUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.penghk.fund.roboadvisor.constant.AdvisorConsts.*;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/16 19:34
 */

@Slf4j
@Service
public class IndexMonitorImpl implements IndexMonitor {


    @Autowired
    TushareUtils tushareUtils;

    @Override
    public IndexDaily getIndexDaily(String txCode, String tradeDate, String startDate, String endDate) {

        IndexRequest indexRequest = IndexRequest.builder()
                .tsCode(txCode)
                .tradeDate(tradeDate)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        Request request = Request.builder()
                .apiName(INDEX_DAILY)
                .token(TUSHARE_TOKEN)
                .params(indexRequest)
                .fields(INDEX_DAILY_FIELDS)
                .build();

        return tushareUtils.getIndexDaily(request);
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void getIndexDaily() {

        String txCode = TsCodeEnum.HS_300.getCode();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String nowDate = simpleDateFormat.format(new Date());

        IndexDaily index = getIndexDaily(txCode, nowDate, null, null);

        log.info(JSON.toJSONString(index));

    }

}
