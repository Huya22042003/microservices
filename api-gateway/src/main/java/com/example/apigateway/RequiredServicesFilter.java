//package com.example.apigateway;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Configuration
//public class RequiredServicesFilter implements GatewayFilter, Ordered {
//
//    private static final String REQUIRED_SERVICES_HEADER = "Required-Services";
//    private static final String ROUTE_HEADER = "Route";
//
//    private final String[] requiredServices;
//
//    public RequiredServicesFilter(String[] requiredServices) {
//        this.requiredServices = requiredServices;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String route = exchange.getRequest().getHeaders().getFirst(ROUTE_HEADER);
//        if (route != null && !isRequiredService(route)) {
//            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//            return exchange.getResponse().setComplete();
//        }
//        return chain.filter(exchange);
//    }
//
//    private boolean isRequiredService(String route) {
//        for (String requiredService : requiredServices) {
//            if (requiredService.equals(route)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public int getOrder() {
//        return Ordered.LOWEST_PRECEDENCE;
//    }
//}
