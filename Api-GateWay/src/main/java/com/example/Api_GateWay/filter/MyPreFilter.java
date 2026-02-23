package com.example.Api_GateWay.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;  // ✅ Correct Import
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyPreFilter implements GlobalFilter {

    private static final Logger logger =
            LoggerFactory.getLogger(MyPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();

        logger.info("Gateway Pre Filter Executed");

        // Print all headers
        headers.forEach((key, value) ->
                logger.info("{} : {}", key, value)
        );

        return chain.filter(exchange);
    }
}