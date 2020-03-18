package com.penghk.fund.roboadvisor.entity;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseData {

    JSONArray fields;

    JSONArray items;

    boolean has_more;

}
