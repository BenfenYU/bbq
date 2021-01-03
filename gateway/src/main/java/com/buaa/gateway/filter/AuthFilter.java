package com.buaa.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String login = exchange.getRequest().getPath().value();

        System.out.println("pre "+login);

        if(login.equals("/oauth2-client/login")){
            System.out.println(login);
            return chain.filter(exchange);
        }

        String register = exchange.getRequest().getPath().value();

        if(register.equals("/oauth2-client/register")){
            System.out.println(register);
            return chain.filter(exchange);
        }

        String token = exchange.getRequest().getQueryParams().getFirst("token");
        //System.out.println(token);
        if(token == null || token.isEmpty()){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
