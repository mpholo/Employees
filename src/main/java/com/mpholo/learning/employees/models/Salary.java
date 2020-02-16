package com.mpholo.learning.employees.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="salaries")
public class Salary implements Serializable {


    @EmbeddedId
    protected SalaryId salaryId;

    private int salary;
    @ManyToOne
    @MapsId("empNo")
    @JoinColumn(name="emp_no")
    private Employee employee;
    private LocalDate toDate;




}
