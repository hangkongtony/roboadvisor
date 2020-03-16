package com.penghk.fund.roboadvisor.util;

import com.alibaba.fastjson.JSON;
import com.penghk.fund.roboadvisor.entity.Index;
import com.penghk.fund.roboadvisor.entity.Request;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.penghk.fund.roboadvisor.constant.AdvisorConsts.*;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/16 19:51
 */

@Slf4j
@Component
public class TushareUtils {


    @Autowired
    private HttpClient httpClient;

    @Autowired
    private RequestConfig requestConfig;


    public Index getIndexDaily(Request request) {

        HttpPost httpPost = new HttpPost(TUSHARE_DATA_URL);
        httpPost.setConfig(requestConfig);

        // 解决中文乱码问题
        String requestStr = JSON.toJSONString(request);
        log.info("request : {}", requestStr);
        StringEntity entity = new StringEntity(requestStr, UTF8);
//        entity.setContentEncoding(UTF8);
        entity.setContentType(JSON_CONTENT_TYPE);
        httpPost.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == SUCCESS_RESPONSE_CODE) {

                HttpEntity he = response.getEntity();
                try {
                    String respContent = EntityUtils.toString(he, UTF8);
                    //todo
                    log.info("get response : {}", respContent);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
