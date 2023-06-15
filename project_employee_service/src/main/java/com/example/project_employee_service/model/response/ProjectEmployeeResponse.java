package com.example.project_employee_service.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEmployeeResponse {

    private Long id;

    private EmployeeResponse employeeResponses;

    private ProjectResponse projectResponse;

}
