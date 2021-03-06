package com.mpholo.learning.employees.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@MappedSuperclass
@EqualsAndHashCode(of={"empNo","deptNo"})
public class EmpDeptRelation {

    @EmbeddedId
    EmpDeptRelationIdentity empDeptRelation;

    @Embedded
    Period period;

    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("deptNo")
    @JoinColumn(name="dept_no")
    private Department department;

    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("empNo")
    @JoinColumn(name="emp_no")
    private Employee employee;


}
