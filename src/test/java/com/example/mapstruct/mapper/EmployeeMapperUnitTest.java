package com.example.mapstruct.mapper;

import com.example.mapstruct.MapstructApplication;
import com.example.mapstruct.dto.DivisionDTO;
import com.example.mapstruct.dto.EmployeeDTO;
import com.example.mapstruct.entity.Division;
import com.example.mapstruct.entity.Employee;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = MapstructApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeMapperUnitTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    @Test
    public void A_employeeToEmployeeDTO() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        Employee employee = new Employee();
        employee.setId(Long.valueOf(1));
        employee.setName("PlatEon");
        employee.setSurname("BlueNeon");
        employee.setStartDate(new Date());
        Division division = new Division();
        division.setName("Developers");
        division.setCity("Naples, Italy");
        division.setCountry("Italy");
        employee.setDivision(division);

        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);

        assertEquals(employeeDTO.getEmployeeName(),employee.getName());
        assertEquals(employeeDTO.getEmployeeSurname(),employee.getSurname());
        assertEquals(dateFormat.parse(employeeDTO.getEmployeeStartDate()).toString(),employee.getStartDate().toString());
        assertEquals(employeeDTO.getEmployeeDivision().getDivisionName(),employee.getDivision().getName());
        assertEquals(employeeDTO.getEmployeeDivision().getDivisionCity(),employee.getDivision().getCity());
        assertEquals(employeeDTO.getEmployeeDivision().getDivisionCountry(),employee.getDivision().getCountry());

    }

    @Test
    public void B_employeeDTOToEmployee() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeName("Zawn");
        employeeDTO.setEmployeeSurname("Bre");
        employeeDTO.setEmployeeStartDate(dateFormat.format(new Date()));
        DivisionDTO divisionDTO = new DivisionDTO();
        divisionDTO.setDivisionName("Hazmart Clerks");
        divisionDTO.setDivisionCity("Amsterdam, New York");
        divisionDTO.setDivisionCountry("USA");
        employeeDTO.setEmployeeDivision(divisionDTO);

        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        employee.setId(Long.valueOf(2));

        assertEquals(employee.getName(),employeeDTO.getEmployeeName());
        assertEquals(employee.getSurname(),employeeDTO.getEmployeeSurname());
        assertEquals(employee.getStartDate().toString(),dateFormat.parse(employeeDTO.getEmployeeStartDate()).toString());
        assertEquals(employee.getDivision().getName(),employeeDTO.getEmployeeDivision().getDivisionName());
        assertEquals(employee.getDivision().getCity(),employeeDTO.getEmployeeDivision().getDivisionCity());
        assertEquals(employee.getDivision().getCountry(),employeeDTO.getEmployeeDivision().getDivisionCountry());

    }

    @Test
    public void C_convertEmployeeListToEmployeeDTOList() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        Employee employee = new Employee();
        employee.setId(Long.valueOf(1));
        employee.setName("PlatEon");
        employee.setSurname("BlueNeon");
        employee.setStartDate(new Date());
        Division division = new Division();
        division.setName("Developers");
        division.setCity("Naples, Campania");
        division.setCountry("Italy");
        employee.setDivision(division);

        Employee employee2 = new Employee();
        employee2.setId(Long.valueOf(2));
        employee2.setName("PlatEon");
        employee2.setSurname("BlueNeon");
        employee2.setStartDate(new Date());
        Division division2 = new Division();
        division2.setName("Developers");
        division2.setCity("Naples, Italy");
        division2.setCountry("Italy");
        employee2.setDivision(division2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee2);

        List<EmployeeDTO> employeeDTOList = employeeMapper.convertEmployeeListToEmployeeDTOList(employeeList);

        EmployeeDTO employeeDTO = employeeDTOList.get(0);
        assertEquals(employeeDTO.getEmployeeName(),employee.getName());
        assertEquals(employeeDTO.getEmployeeSurname(),employee.getSurname());
        assertEquals(dateFormat.parse(employeeDTO.getEmployeeStartDate()).toString(),employee.getStartDate().toString());
        assertEquals(employeeDTO.getEmployeeDivision().getDivisionName(),employee.getDivision().getName());
        assertEquals(employeeDTO.getEmployeeDivision().getDivisionCity(),employee.getDivision().getCity());
        assertEquals(employeeDTO.getEmployeeDivision().getDivisionCountry(),employee.getDivision().getCountry());

        EmployeeDTO employeeDTO2 = employeeDTOList.get(1);
        assertEquals(employeeDTO2.getEmployeeName(),employee2.getName());
        assertEquals(employeeDTO2.getEmployeeSurname(),employee2.getSurname());
        assertEquals(dateFormat.parse(employeeDTO2.getEmployeeStartDate()).toString(),employee2.getStartDate().toString());
        assertEquals(employeeDTO2.getEmployeeDivision().getDivisionName(),employee2.getDivision().getName());
        assertEquals(employeeDTO2.getEmployeeDivision().getDivisionCity(),employee2.getDivision().getCity());
        assertEquals(employeeDTO2.getEmployeeDivision().getDivisionCountry(),employee2.getDivision().getCountry());

    }

    @Test
    public void D_convertEmployeeDTOListToEmployeeList() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeName("PlatEon");
        employeeDTO.setEmployeeSurname("BlueNeon");
        employeeDTO.setEmployeeStartDate(dateFormat.format(new Date()));
        DivisionDTO divisionDTO = new DivisionDTO();
        divisionDTO.setDivisionName("Developers");
        divisionDTO.setDivisionCity("Naples, Campania");
        divisionDTO.setDivisionCountry("Italy");
        employeeDTO.setEmployeeDivision(divisionDTO);

        EmployeeDTO employeeDTO2 = new EmployeeDTO();
        employeeDTO2.setEmployeeName("Zawn");
        employeeDTO2.setEmployeeSurname("Bre");
        employeeDTO2.setEmployeeStartDate(dateFormat.format(new Date()));
        DivisionDTO divisionDTO2 = new DivisionDTO();
        divisionDTO2.setDivisionName("Hazmart Clerks");
        divisionDTO2.setDivisionCity("Amsterdam, New York");
        divisionDTO2.setDivisionCountry("USA");
        employeeDTO2.setEmployeeDivision(divisionDTO2);

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        employeeDTOList.add(employeeDTO);
        employeeDTOList.add(employeeDTO2);

        List<Employee> employeeList = employeeMapper.convertEmployeeDTOListToEmployeeList(employeeDTOList);

        Employee employee = employeeList.get(0);
        employee.setId(Long.valueOf(1));
        assertEquals(employee.getName(),employeeDTO.getEmployeeName());
        assertEquals(employee.getSurname(),employeeDTO.getEmployeeSurname());
        assertEquals(employee.getStartDate().toString(),dateFormat.parse(employeeDTO.getEmployeeStartDate()).toString());
        assertEquals(employee.getDivision().getName(),employeeDTO.getEmployeeDivision().getDivisionName());
        assertEquals(employee.getDivision().getCity(),employeeDTO.getEmployeeDivision().getDivisionCity());
        assertEquals(employee.getDivision().getCountry(),employeeDTO.getEmployeeDivision().getDivisionCountry());

        Employee employee2 = employeeList.get(1);
        employee.setId(Long.valueOf(2));
        assertEquals(employee2.getName(),employeeDTO2.getEmployeeName());
        assertEquals(employee2.getSurname(),employeeDTO2.getEmployeeSurname());
        assertEquals(employee2.getStartDate().toString(),dateFormat.parse(employeeDTO2.getEmployeeStartDate()).toString());
        assertEquals(employee2.getDivision().getName(),employeeDTO2.getEmployeeDivision().getDivisionName());
        assertEquals(employee2.getDivision().getCity(),employeeDTO2.getEmployeeDivision().getDivisionCity());
        assertEquals(employee2.getDivision().getCountry(),employeeDTO2.getEmployeeDivision().getDivisionCountry());

    }

}