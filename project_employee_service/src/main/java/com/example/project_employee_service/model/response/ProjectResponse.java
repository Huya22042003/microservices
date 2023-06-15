package com.example.project_employee_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

    private Long id;

    private String ma;

    private String ten;

    private String ngayBatDau;

    private String ngayKeThuc;

}
