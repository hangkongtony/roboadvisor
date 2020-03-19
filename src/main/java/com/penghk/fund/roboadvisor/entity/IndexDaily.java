package com.penghk.fund.roboadvisor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 指数日线行情
 * @Author:hangkong.peng
 * @Date: 2020/3/16 19:30
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndexDaily {

    /**
     * TS指数代码
     */
    private String tsCode;

    /**
     * 交易日
     */
    private String tradeDate;

    /**
     * 收盘点位
     */
    private BigDecimal close;

    /**
     * 开盘点位
     */
    private BigDecimal open;

    /**
     * 最高点位
     */
    private BigDecimal high;

    /**
     * 最低点位
     */
    private BigDecimal low;

    /**
     * 昨日收盘点
     */
    private BigDecimal preClose;

    /**
     * 涨跌点
     */
    private BigDecimal change;

    /**
     * 涨跌幅（%）
     */
    private BigDecimal pctChg;

    /**
     * 成交量（手）
     */
    private BigDecimal vol;

    /**
     * 成交额（千元）
     */
    private BigDecimal amount;


}
