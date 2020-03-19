package com.penghk.fund.roboadvisor;

import com.penghk.fund.roboadvisor.entity.IndexDaily;
import com.penghk.fund.roboadvisor.tushare.IndexRequest;
import com.penghk.fund.roboadvisor.tushare.Request;
import com.penghk.fund.roboadvisor.util.TushareUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.penghk.fund.roboadvisor.constant.AdvisorConsts.*;

@SpringBootTest
class RoboadvisorApplicationTests {


    @Autowired
    TushareUtils tushareUtils;

    @Test
    void getIndexDaily() {

        IndexRequest indexRequest = IndexRequest.builder().tsCode("000300.SH").tradeDate("20200318").build();

        Request request = Request.builder()
                .apiName(INDEX_DAILY)
                .token(TUSHARE_TOKEN)
                .params(indexRequest)
                .fields(INDEX_DAILY_FIELDS)
                .build();

        IndexDaily index = tushareUtils.getIndexDaily(request);
        System.out.println(index);
    }
}
