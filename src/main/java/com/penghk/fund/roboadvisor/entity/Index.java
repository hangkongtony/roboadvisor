package com.penghk.fund.roboadvisor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/16 19:30
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Index {

    /**
     * TS指数代码
     */
    private String txCode;

}
