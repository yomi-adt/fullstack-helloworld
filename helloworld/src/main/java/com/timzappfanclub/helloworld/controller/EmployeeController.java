package com.timzappfanclub.helloworld.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timzappfanclub.helloworld.service.EmployeeService;
import com.timzappfanclub.helloworld.dto.EmployeeDto;

import lombok.AllArgsConstructor;

import java.util.List;

// Makes this class capable of handling HTTP requests
@RestController
// Defines the base URL that calls this class
@RequestMapping("/api/employees")
@AllArgsConstructor

// Solve CORS
@CrossOrigin("*")
public class EmployeeController {
    private EmployeeService employeeService;

    // Build add employee API
    // This annotation maps POST http request to this method
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody /* Maps this param to request body. Converts JSON to EmployeeDto object */ EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        // Returns a response entity
        // Generic type that sends an HTTP response. For more documentation, see
        // https://www.geeksforgeeks.org/how-to-use-spring-responseentity-to-manipulate-the-http-response/
        // https://stackoverflow.com/questions/26550124/spring-returning-empty-http-responses-with-responseentityvoid-doesnt-work
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @GetMapping("{id}") // Adds on to request mapping. So GET /api/employees/{id} maps to this function call
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") /* Maps this variable to the id passed in the path */ long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Get all Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Build update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, 
                                                      @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // Build delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
