package com.timzappfanclub.helloworld.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/*
 * What is DTO?
 * Stands for Data Transfer Object
 * 
 * It's a software design pattern that encapsulates data. It "summarizes" object
 * data so that it can be sent to other layers/subsytems of an application. (It's kind
 * of like what JSON does)
 * 
 * In our case, we use DTOs to act as "plumbing" from the database layer to our UI.
 * 
 * Note that this isn't 100% ncessary, but it does further decouple midware from
 * the rest of the application AND provides a method of data transfer should the 
 * application expand to more tiers.
 * 
 */
public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDto(String fname, String lname, String mail){
        firstName=fname;
        lastName=lname;
        email=mail;
    }

}
