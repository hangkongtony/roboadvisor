package com.penghk.fund.roboadvisor.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/16 20:23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {

    @JSONField(name = "api_name")
    String apiName;

    @JSONField(name = "token")
    String token;

    @JSONField(name = "params")
    RequestParams params;

    @JSONField(name = "fields")
    String fields;

}
