package com.mpholo.learning.employees.services;

import com.mpholo.learning.employees.models.Department;
import com.mpholo.learning.employees.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
   public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department findById(String s) {
        return departmentRepository.findById(s).orElse(null);
    }

    @Override
    public List<Department> findAll() {
       return departmentRepository.findAll();
    }

    @Override
    public void deleteById(String s) {
        departmentRepository.deleteById(s);

    }

    @Override
    public void delete(Department object) {
         departmentRepository.delete(object);
    }

    @Override
    public void save(Department object) {
        departmentRepository.save(object);

    }

}
