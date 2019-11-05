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
@Entity
@Table(name="employees")
public class Employee  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_no;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;

    @Enumerated(value=EnumType.STRING)
    Gender gender;
    private LocalDate hireDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Salary> salariesList;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="dept_emp",joinColumns = @JoinColumn(name="emp_no"),
    inverseJoinColumns = @JoinColumn(name="dept_no"))
    private Set<Department> departments = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="dept_manager",joinColumns = @JoinColumn(name="emp_no"),
    inverseJoinColumns = @JoinColumn(name="dept_no"))
    private  Set<Department> managers = new HashSet<>();





}
