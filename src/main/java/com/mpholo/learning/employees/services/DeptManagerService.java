package com.mpholo.learning.employees.services;

import com.mpholo.learning.employees.models.DeptManager;
import com.mpholo.learning.employees.models.EmpDeptRelationIdentity;

import java.util.List;

public interface DeptManagerService extends CrudService<DeptManager, EmpDeptRelationIdentity> {

    List<DeptManager> findByDeptNo(String deptNo);
}
