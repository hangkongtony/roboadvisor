package com.penghk.fund.roboadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/13 16:37
 */

@Controller
public class InvestController {

    @RequestMapping("/")
    public String init() {
        return "index";
    }

}
