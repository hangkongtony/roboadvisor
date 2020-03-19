package com.penghk.fund.roboadvisor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/19 18:42
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Index {

    Integer id;

    /**
     * TS代码
     */
    String tsCode;

    /**
     * 简称
     */
    String name;

    /**
     * 指数全称
     */
    String fullname;

    /**
     * 市场
     */
    String market;

    /**
     * 发布方
     */
    String publisher;

    /**
     * 指数风格
     */
    String indexType;

    /**
     * 指数类别
     */
    String category;

    /**
     * 基期
     */
    String baseDate;

    /**
     * 基点
     */
    Float basePoint;

    /**
     * 发布日期
     */
    String listDate;

    /**
     * 加权方式
     */
    String weightRule;

    /**
     * 描述
     */
    String desc;

    /**
     * 终止日期
     */
    String expDate;

    private Long version = 1L;

    private Date createTime;

    private Date lastUpdateTime;

}
