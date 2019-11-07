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
@Table(name="titles")
public class Title extends  BaseEntity {

    private String title;
    @Embedded
    private Period period;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employees;




}
