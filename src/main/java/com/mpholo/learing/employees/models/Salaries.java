package com.mpholo.learing.employees.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Salaries extends BaseEntity {

    private int salary;
    @ManyToOne
    @JoinColumn(name="employees_id")
    private Set<Employees> employees = new HashSet<>();
    private  Period period;


}
