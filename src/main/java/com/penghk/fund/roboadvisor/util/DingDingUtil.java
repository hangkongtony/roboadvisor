package com.penghk.fund.roboadvisor.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

@Slf4j
public class DingDingUtil {


    private final static int HTTP_STATUS_OK = 200;

    public static void sendDingDingNotify(String dingUrl, JSONObject contentJson) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(dingUrl);
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(1000).setSocketTimeout(1000).
                setConnectionRequestTimeout(1000).build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");

        String content = contentJson.toJSONString();
        StringEntity stringEntity = new StringEntity(content, "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(stringEntity);

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatusLine().getStatusCode() != HTTP_STATUS_OK) {
            log.warn("发送钉钉失败");
        }
    }




}
