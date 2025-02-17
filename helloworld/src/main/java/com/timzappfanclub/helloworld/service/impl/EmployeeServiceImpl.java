package com.timzappfanclub.helloworld.service.impl;

import com.timzappfanclub.helloworld.service.EmployeeService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import com.timzappfanclub.helloworld.dto.EmployeeDto;
import com.timzappfanclub.helloworld.mapper.EmployeeMapper;
import com.timzappfanclub.helloworld.repository.EmployeeRepository;
import com.timzappfanclub.helloworld.entity.Employee;

// This annotation tells the container to create the Spring Bean for this class
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    // Dependency
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee); // Returns the saved employee object

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
