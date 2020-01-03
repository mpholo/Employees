package com.mpholo.learning.employees.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dept_emp")
public class DeptEmp extends EmpDeptRelation {
}
