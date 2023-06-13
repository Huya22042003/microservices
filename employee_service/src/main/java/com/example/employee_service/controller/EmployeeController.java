package com.example.employee_service.controller;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private WebClient webClient;

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity getAll(@RequestParam(name = "search", defaultValue = "") String search,
                                 @RequestParam(name = "page", defaultValue = "0") int page) {
        return ResponseEntity.ok().body(service.getList(search, page));
    }

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        Employee employee1 = service.addEmployee(employee);
        if (employee1 != null) {
            return ResponseEntity.ok().body(employee1);
        }
        return ResponseEntity.badRequest().body("Thêm thất bại");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEmployee(@RequestBody Employee employee,
                                         @PathVariable(name = "id") Long id) {

        Employee employee1 = service.updateEmployee(employee, id);
        if (employee1 != null) {
            return ResponseEntity.ok().body(employee1);
        }
        return ResponseEntity.badRequest().body("Sửa thất bại");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(name = "id") Long id) {
        if (!service.deleteEmployee(id)) {
            return ResponseEntity.ok().body("Xóa thất bại");
        }
        return ResponseEntity.badRequest().body("Xóa thành công");
    }

//    @GetMapping("/test")
//    public String helloWorld() {
//        return webClient.get()
//                .uri("http://localhost:8082/api/project")
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//    }
}
