package com.mpholo.learning.employees.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="salaries")
public class Salary extends BaseEntity {


    private int salary;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
   @Embedded
    private Period period;


}
