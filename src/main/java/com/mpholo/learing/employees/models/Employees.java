package com.mpholo.learing.employees.models;

import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employees extends BaseEntity {

    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    Gender gender;
    private Local hireDate;



}
