package com.penghk.fund.roboadvisor.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.penghk.fund.roboadvisor.entity.IndexDaily;
import com.penghk.fund.roboadvisor.enums.TsCodeEnum;
import com.penghk.fund.roboadvisor.service.IndexMonitor;
import com.penghk.fund.roboadvisor.service.WeekInvestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/13 16:33
 */

@Slf4j
@Service
public class WeekInvestServiceImpl implements WeekInvestService {

    @Value(value = "${weekInvest.dingUrl}")
    private String dingUrl;

    @Autowired
    private IndexMonitor indexMonitor;
    /**
     *
     * @param presentPoint 当前沪深300点位
     * @param basePoint 基准点位
     * @param baseInvest 基准投资金额
     * @param scale 放大指数
     * @return
     */
    @Override
    public double calculateWeekInvestAmount(double presentPoint, double basePoint, double baseInvest, double scale) {
        double div = Math.pow(presentPoint / basePoint, scale);
        return baseInvest / div;
    }


    /**
     * 每周二下午2:30计算每周应投资金额
     */
    @Scheduled(cron = "0 30 14 * * 3")
    public void weekReport() {

        String txCode = TsCodeEnum.HS_300.getCode();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        LocalDate localDate = LocalDate.now().minusDays(1);
        String yesterday = formatter.format(localDate);

        IndexDaily indexDaily = indexMonitor.getIndexDaily(txCode, yesterday, null, null);
        double presentPoint = indexDaily.getClose().doubleValue();
        double presentInvest = calculateWeekInvestAmount(presentPoint, 4000, 500, 5);
        DecimalFormat df = new DecimalFormat("######0.00");
        String presentInvestStr = df.format(presentInvest);
        log.info("presentInvest : {}", presentInvestStr);

        JSONObject contentJson = new JSONObject();
        contentJson.put("msgtype", "text");
        JSONObject textJsonObj = new JSONObject();
        String contentValue = "小丁 : hello world";
        textJsonObj.put("content", contentValue);
        contentJson.put("text", textJsonObj);

//        DingDingUtil.sendDingDingNotify(dingUrl, contentJson);

    }

    public static void main(String[] args) {

        WeekInvestService weekInvestService = new WeekInvestServiceImpl();
        double basePoint = 4000;
        double baseInvest = 500;
        double scale = 5;
        System.out.println("3000点以下，全仓买入");
        for (double presentPoint = 3000; presentPoint <= 4000; presentPoint += 100) {
            System.out.println("沪深300点位 : "+ presentPoint + " # 每周投资金额 : " + weekInvestService.calculateWeekInvestAmount(presentPoint, basePoint, baseInvest, scale));
        }

    }

}
