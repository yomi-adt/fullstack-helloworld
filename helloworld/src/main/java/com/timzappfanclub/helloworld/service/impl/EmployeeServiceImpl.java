package com.timzappfanclub.helloworld.service.impl;

import com.timzappfanclub.helloworld.service.EmployeeService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.timzappfanclub.helloworld.dto.EmployeeDto;
import com.timzappfanclub.helloworld.mapper.EmployeeMapper;
import com.timzappfanclub.helloworld.repository.EmployeeRepository;
import com.timzappfanclub.helloworld.entity.Employee;
import com.timzappfanclub.helloworld.exception.ResourceNotFoundException;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId){
        // Built in CRUD method for finding by ID
        Employee employee = employeeRepository.findById(employeeId)
        /*
         * Two things here:
         * 
         * 1) .orElseThrow() is a "method chain". employeeRepository.findById() returns an Optional<> class, then Optional<>.orElseThrow() is invoked
         * 
         * 2) Lambda expression (params) -> expression. Basically: API provides a method with an interface, while user of API can define functionality
         * In this case: Optional.orElseThrow() defines the interface where if Optional is not empty, the returns contents of Optional. Otherwise, throws
         * specified exception. In the expression, user defines what exception to throw (ResourceNotFoundException) 
         */
            .orElseThrow(() -> new ResourceNotFoundException("Employee with that ID does not exist in database."));
        
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        // I hate this, but basically for every employee from db returned, convert to EmployeeDto and return as a List<>
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found. Id: "+ employeeId));

        // Update the returned employee's data
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        // Built in CRUD method
        // Note that the employee object has an ID attached to it. What likely happens is that this id
        // is searched for in db and columns are updated
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found. Id: "+ employeeId));

        // Built in CRUD method
        employeeRepository.deleteById(employeeId);
    }
}
