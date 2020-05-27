package com.example.mapstruct.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {

    private Long id;
    private String name;
    private String surname;
    private Division division;
    private Date startDate;

}
