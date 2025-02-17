package com.timzappfanclub.helloworld.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timzappfanclub.helloworld.service.EmployeeService;
import com.timzappfanclub.helloworld.dto.EmployeeDto;

import lombok.AllArgsConstructor;

// Makes this class capable of handling HTTP requests
@RestController
// Defines the base URL that calls this class
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // Build add employee API
    // This annotation maps POST http request to this method
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        System.out.println(employeeDto.getEmail() + employeeDto.getFirstName() + employeeDto.getLastName());
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        // Returns a response entity
        // TODO: Look at ResponseEntity documentation and what this constructor does
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<EmployeeDto> createEmployeeTest(){
        EmployeeDto savedEmployee = employeeService.createEmployee(new EmployeeDto("Nik", "Get", "bruh@gmail.com"));

        // Returns a response entity
        // TODO: Look at ResponseEntity documentation and what this constructor does
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
}
