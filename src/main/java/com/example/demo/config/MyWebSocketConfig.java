package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yeauty.standard.ServerEndpointExporter;

@Configuration
public class MyWebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        // new一个ServerEndpointExporter对象，交给Spring容器，表示要开启WebSocket功能
        return new ServerEndpointExporter();
    }
}
