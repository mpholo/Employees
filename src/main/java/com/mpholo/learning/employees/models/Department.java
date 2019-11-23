package com.mpholo.learning.employees.models;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode(of="deptNo")
@Entity
@Table(name="departments")
public class Department {

    @Id
    @Column(name="dept_no")
    private String deptNo;
    private String deptName;


}
