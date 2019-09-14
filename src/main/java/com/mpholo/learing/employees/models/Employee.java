package com.mpholo.learing.employees.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee extends BaseEntity {

    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    Gender gender;
    private LocalDate hireDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Salary> salariesList;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="employee_departments",joinColumns = @JoinColumn(name="employee_id"),
    inverseJoinColumns = @JoinColumn(name="department_id"))
    private Set<Department> departments = new HashSet<>();



}
