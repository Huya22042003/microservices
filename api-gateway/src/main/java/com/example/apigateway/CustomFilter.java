//package com.example.apigateway;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//public class CustomFilter implements GlobalFilter, Ordered {
//
//    private static final int FILTER_ORDER = 1;
//
//    private static final String SECURITY_SERVICE_ID = "security-service";
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // Kiểm tra xem service hiện tại có ID là mandatory service ID hay không
//        String serviceId = exchange.getRequest().getHeaders().getFirst("X-Service-Id");
//        if (SECURITY_SERVICE_ID.equals(serviceId)) {
//            // Nếu là mandatory service, tiếp tục chuyển tiếp yêu cầu
//            return chain.filter(exchange);
//        } else {
//            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//            return exchange.getResponse().setComplete();
//        }
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;
//    }
//}
