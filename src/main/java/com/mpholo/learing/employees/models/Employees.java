package com.mpholo.learing.employees.models;

import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employees extends BaseEntity {

    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    Gender gender;
    private Local hireDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employees")
    private List<Salaries> salariesList;



}
