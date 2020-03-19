package com.penghk.fund.roboadvisor.tushare;

import com.alibaba.fastjson.annotation.JSONField;
import com.penghk.fund.roboadvisor.tushare.RequestParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/16 20:00
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndexRequest implements RequestParams {

    @JSONField(name = "ts_code")
    String tsCode;

    @JSONField(name = "trade_date")
    String tradeDate;

    @JSONField(name = "start_date")
    String startDate;

    @JSONField(name = "end_date")
    String endDate;

}
