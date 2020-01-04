package com.mpholo.learning.employees.services;

import com.mpholo.learning.employees.models.DeptManager;
import com.mpholo.learning.employees.models.EmpDeptRelationIdentity;
import com.mpholo.learning.employees.repositories.DeptManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptManagerServiceImpl implements DeptManagerService {


    private final DeptManagerRepository deptManagerRepository;

    public DeptManagerServiceImpl(DeptManagerRepository deptManagerRepository) {
        this.deptManagerRepository = deptManagerRepository;
    }

    @Override
    public List<DeptManager> findByDeptNo(String deptNo) {
        return deptManagerRepository.findByEmpDeptRelationDeptNo(deptNo);
    }

    @Override
    public DeptManager findById(EmpDeptRelationIdentity empDeptRelationIdentity) {
        return null;
    }

    @Override
    public List<DeptManager> findAll() {
        return null;
    }

    @Override
    public void deleteById(EmpDeptRelationIdentity empDeptRelationIdentity) {

    }

    @Override
    public void delete(DeptManager object) {

    }

    @Override
    public void save(DeptManager object) {

    }
}
