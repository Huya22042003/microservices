package com.example.employee_service.service.impl;

import com.example.employee_service.entity.Employee;
import com.example.employee_service.model.response.PageableObject;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

//    @Bean
//    public void themTruoc() {
//        List<Employee> list = new ArrayList<>();
//        list.add(new Employee(1L, "NV001", "Nguyễn Thị Hồng", 18));
//        list.add(new Employee(2L, "NV002", "Trần Văn Minh", 18));
//        list.add(new Employee(3L, "NV003", "Lê Thị Kim Anh", 18));
//        list.add(new Employee(4L, "NV004", "Phạm Đức Hùng", 18));
//        list.add(new Employee(5L, "NV005", "Hoàng Thanh Trúc", 18));
//        list.add(new Employee(6L, "NV006", "Huỳnh Quang Tuấn", 18));
//        list.add(new Employee(7L, "NV007", "Đặng Thị Thu Hà", 18));
//        list.add(new Employee(8L, "NV008", "Vũ Quang Trung", 18));
//        list.add(new Employee(9L, "NV009", "Đỗ Thị Mai Linh", 18));
//        list.add(new Employee(10L, "NV0010", "Ngô Xuân Phúc", 18));
//        repository.saveAll(list);
//
//    }

    @Override
    public PageableObject<Employee> getList(String search, int total) {
        Pageable pageable = PageRequest.of(total, 10);
        Page page = repository.findByMaContainsOrTenContainsOrderById(search, search, pageable);
        return new PageableObject<>(page);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        try {
            return repository.save(employee);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        employee.setId(id);
        try {
            return repository.save(employee);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteEmployee(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Employee findById(Long id) {
        return repository.findById(id).get();
    }
}
