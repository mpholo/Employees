package com.mpholo.learing.employees.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="titles")
public class Title extends  BaseEntity {

    private String title;
    private LocalDate fromDate;
    private LocalDate toDate;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employees;




}
