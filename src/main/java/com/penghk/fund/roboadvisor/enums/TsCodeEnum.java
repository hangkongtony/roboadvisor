package com.penghk.fund.roboadvisor.enums;

/**
 * 关注的指数代码
 */
public enum TsCodeEnum {

    /**
     * 沪深300
     *  <a>http://www.csindex.com.cn/zh-CN/indices/index-detail/000300</a>
     */
    HS_300("000300.SH", "沪深300");

    private String code;

    private String name;

    TsCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
