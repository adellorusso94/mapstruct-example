package com.example.mapstruct.mapper;

import com.example.mapstruct.dto.DivisionDTO;
import com.example.mapstruct.dto.EmployeeDTO;
import com.example.mapstruct.entity.Division;
import com.example.mapstruct.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target = "employeeName", source = "employee.name"),
            @Mapping(target = "employeeSurname", source = "employee.surname"),
            @Mapping(target = "employeeStartDate", source = "employee.startDate", dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target = "employeeDivision", source = "employee.division")
    })
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @Mappings({
            @Mapping(target = "name", source = "employeeDTO.employeeName"),
            @Mapping(target = "surname", source = "employeeDTO.employeeSurname"),
            @Mapping(target = "startDate", source = "employeeDTO.employeeStartDate", dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target = "division", source = "employeeDTO.employeeDivision")
    })
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);

    @Mappings({
            @Mapping(target = "divisionName", source = "division.name"),
            @Mapping(target = "divisionCity", source = "division.city"),
            @Mapping(target = "divisionCountry", source = "division.country")
    })
    DivisionDTO divisionToDivisionDTO(Division division);

    @Mappings({
            @Mapping(target = "name", source = "divisionDTO.divisionName"),
            @Mapping(target = "city", source = "divisionDTO.divisionCity"),
            @Mapping(target = "country", source = "divisionDTO.divisionCountry")
    })
    Division divisionDTOToDivision(DivisionDTO divisionDTO);

    List<Employee> convertEmployeeDTOListToEmployeeList(List<EmployeeDTO> employeeDTOs);

    List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> employees);

}
