package com.penghk.fund.roboadvisor.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {

    @JSONField(name = "request_id")
    String requestId;

    int code;

    String msg;

    ResponseData data;

}
