package com.penghk.fund.roboadvisor.enums;

/**
 * 指数代码
 */
public enum TsCodeEnum {

    /**
     * 沪深300
     *  <a>http://www.csindex.com.cn/zh-CN/indices/index-detail/000300</a>
     */
    HS_300("000300.SH");

    private String code;

    TsCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
