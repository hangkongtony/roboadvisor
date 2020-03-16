package com.penghk.fund.roboadvisor.service;

/**
 * 每周定投服务
 * @Author:hangkong.peng
 * @Date: 2020/3/13 16:31
 */

public interface WeekInvestService {

    /**
     *
     * @param presentPoint 当前沪深300点位
     * @param basePoint 基准点位
     * @param baseInvest 基准投资金额
     * @param scale 放大指数
     * @return
     */
    double calculateWeekInvestAmount(double presentPoint, double basePoint, double baseInvest, double scale);


}
