package com.example.mapstruct.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private String employeeName;
    private String employeeSurname;
    private DivisionDTO employeeDivision;
    private String employeeStartDate;

}
