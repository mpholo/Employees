package com.mpholo.learning.employees.services;

import com.mpholo.learning.employees.models.DeptEmp;
import com.mpholo.learning.employees.models.EmpDeptRelationIdentity;
import com.mpholo.learning.employees.repositories.DeptEmpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptEmpServiceImpl implements DeptEmpService {

    private  final DeptEmpRepository deptEmpRepository;

    public DeptEmpServiceImpl(DeptEmpRepository deptEmpRepository) {
        this.deptEmpRepository = deptEmpRepository;
    }

    @Override
    public Optional<DeptEmp> findByEmpDeptRelation(EmpDeptRelationIdentity empDeptRelationIdentity) {
        return deptEmpRepository.findByEmpDeptRelation(empDeptRelationIdentity);
    }

    @Override
    public List<DeptEmp> findByEmpDeptRelationDeptNo(String deptNo) {
        return deptEmpRepository.findByEmpDeptRelationDeptNo(deptNo);
    }
}
