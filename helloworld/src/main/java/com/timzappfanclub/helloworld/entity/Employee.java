package com.timzappfanclub.helloworld.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// Jakarta annotations: "Set this to be an entity in db" and "Create a table for this entity with the name employees"
@Entity
@Table(name="employees")
public class Employee {

    // Auto-increment an id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Explicitly defines the column name. If not specified, default is variable name
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    // Can also add column constraints!
    @Column(name="email", nullable = false, unique = true)
    private String email;


}
