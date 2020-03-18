package com.penghk.fund.roboadvisor.service.impl;

import com.penghk.fund.roboadvisor.service.WeekInvestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/13 16:33
 */

@Slf4j
@Service
public class WeekInvestServiceImpl implements WeekInvestService {

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


    @Scheduled(cron = "0/30 * * * * ?")
    public void weekReport() {
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
