package com.example.project_employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectEmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectEmployeeServiceApplication.class, args);
    }

}
