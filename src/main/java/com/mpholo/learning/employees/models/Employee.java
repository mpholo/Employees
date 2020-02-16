package com.mpholo.learning.employees.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode(of="empNo")
@ToString
@Entity
@Table(name="employees")
public class Employee  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empNo;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;

    @Enumerated(value=EnumType.STRING)
    Gender gender;
    private LocalDate hireDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee",fetch = FetchType.EAGER)
    private List<Salary> salariesList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<DeptEmp> deptEmps;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Title> titlesList;






}
