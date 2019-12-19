package com.mpholo.learning.employees.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    List<DeptManager> deptManagers;



}
