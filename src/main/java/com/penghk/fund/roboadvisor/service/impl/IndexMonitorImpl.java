package com.penghk.fund.roboadvisor.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.penghk.fund.roboadvisor.entity.IndexDaily;
import com.penghk.fund.roboadvisor.enums.TsCodeEnum;
import com.penghk.fund.roboadvisor.mapper.IndexMapper;
import com.penghk.fund.roboadvisor.service.IndexMonitor;
import com.penghk.fund.roboadvisor.tushare.IndexRequest;
import com.penghk.fund.roboadvisor.tushare.Request;
import com.penghk.fund.roboadvisor.util.DingDingUtil;
import com.penghk.fund.roboadvisor.util.TushareUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static com.penghk.fund.roboadvisor.constant.AdvisorConsts.*;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/16 19:34
 */

@Slf4j
@Service
public class IndexMonitorImpl implements IndexMonitor {

    @Value(value = "${weekInvest.dingUrl}")
    private String dingUrl;

    @Autowired
    IndexMapper indexMapper;

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

    /**
     * 工作日下午3：30监控当天关注的指数涨跌幅
     */
    @Scheduled(cron = "0 30 15,16 * * ?")
    public void monitorIndexDaily() {

        for (TsCodeEnum txCodeEnun : TsCodeEnum.values()) {
            String txCode = txCodeEnun.getCode();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String nowDate = simpleDateFormat.format(new Date());

            IndexDaily index = getIndexDaily(txCode, nowDate, null, null);

            if (Objects.nonNull(index)) {
                BigDecimal pctChg = index.getPctChg();
                if (pctChg.compareTo(new BigDecimal(-3)) < 0) {
                    //跌幅超过3%发送钉钉通知
                    JSONObject contentJson = new JSONObject();
                    contentJson.put("msgtype", "text");
                    JSONObject textJsonObj = new JSONObject();
                    String contentValue = "小丁 : 今天指数[" + txCodeEnun.getName() + "]涨跌幅[" + pctChg.doubleValue() + "%]";
                    textJsonObj.put("content", contentValue);
                    contentJson.put("text", textJsonObj);

                    DingDingUtil.sendDingDingNotify(dingUrl, contentJson);
                }
            }

        }
    }

}
