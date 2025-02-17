package com.timzappfanclub.helloworld.repository;

import com.timzappfanclub.helloworld.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * What is a "repository"?
 * 
 * Repository is the plumbing between the DB and service layers
 * Note that the structure is:
 * [Front End] <-> [Controller, where REST APIs live] <-> [Service Layer] <-> [Repository Layer] <-> [DB]
 * 
 * An interface for performing various database operations.
 * JpaRepository provides implementations to CRUD operations (create, read, update, delete)
 * 
 * Note that JpaReposity is a generic type and needs to be passed <T, ID>, where
 * - T is the type of the stored data
 * - ID is the type of the primary key
 * 
 * By creating an interface that extends this interface, we take the generic interface and create
 * an interface specifically for our needs (i.e. for inserting/deleting/etc. Employees with a Long PK)
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    // This interface comes with implementations from org.springframework.data.jpa.repository
}
