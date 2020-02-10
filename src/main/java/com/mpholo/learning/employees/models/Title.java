package com.mpholo.learning.employees.models;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="titles")
public class Title extends  BaseEntity {

    private String title;
    @Embedded
    private Period period;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;




}
