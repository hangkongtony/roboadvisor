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

    private String tradeDate;

    private BigDecimal close;

    private BigDecimal open;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal preClose;

    private BigDecimal change;

    private BigDecimal pctChg;

    private BigDecimal vol;

    private BigDecimal amount;


}
