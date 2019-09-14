package com.mpholo.learing.employees.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Titles extends  BaseEntity {

    private String title;
    private LocalDate fromDate;
    private LocalDate toDate;

    private Employees employees;



}
