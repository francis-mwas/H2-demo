package com.fram.h2project.service;

import com.fram.h2project.entity.Department;
import com.fram.h2project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DerpatmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department dbDepartment = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&& !"".equalsIgnoreCase(department.getDepartmentName())){
            dbDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode())&& !"".equalsIgnoreCase(department.getDepartmentCode())){
            dbDepartment.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase((department.getDepartmentAddress()))){
            dbDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(dbDepartment);
    }

    @Override
    public Department fetcDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

}