package com.mpholo.learning.employees.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode(of={"empNo","deptNo"})
@AllArgsConstructor
@NoArgsConstructor
public class EmpDeptRelationIdentity implements Serializable {

    @Column(name="emp_no")
    private Long empNo;
    @Column(name="dept_no")
    private String deptNo;





}
