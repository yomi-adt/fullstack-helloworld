package com.timzappfanclub.helloworld.mapper;

import com.timzappfanclub.helloworld.dto.EmployeeDto;
import com.timzappfanclub.helloworld.entity.Employee;

/*
 * What is a mapper?
 * 
 * See the notes on DTOs found in `dto/EmployeeDto.java`
 * 
 * Essentially, is the implementation of converting data to and
 * from DTO objects.
 * 
 */
public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        // Returns an EmployeeDto from an Employee Entity
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
    }

    public  static Employee mapToEmployee(EmployeeDto employee){
        // Returns an Employee entity from an Employee Dto
        return new Employee(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        ); 
    }
}
