package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("security-service", r -> r
                        .path("/api/auth/**")
                        .uri("lb://security-service")
                )
                .route("project-service", r -> r
                        .path("/api/project/**")
                        .uri("lb://project-service")
                )
                .route("employee-service", r -> r
                        .path("/api/employee/**")
                        .uri("lb://employee-service")
                )
                .route("project-employee-service", r -> r
                        .path("/api/project-employee/**")
                        .uri("lb://project-employee-service")
                )
                .build();
    }

}
