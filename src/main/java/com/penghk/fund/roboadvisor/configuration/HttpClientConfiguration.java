package com.penghk.fund.roboadvisor.configuration;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:hangkong.peng
 * @Date: 2020/3/16 19:52
 */

@Configuration
public class HttpClientConfiguration {


    @Bean
    public HttpClient httpClient() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //todo 优化性能
        return httpClient;
    }

    @Bean
    public RequestConfig requestConfig() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();
        return requestConfig;
    }

}
