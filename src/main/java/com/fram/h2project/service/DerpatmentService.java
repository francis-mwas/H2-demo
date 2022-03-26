package com.fram.h2project.service;


import com.fram.h2project.entity.Department;

import java.util.List;


public interface DerpatmentService {
    public Department createDepartment(Department department);
    public List<Department> getDepartments();
    public Department getDepartmentById(Long departmentId);
    public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

   public Department fetcDepartmentByName(String departmentName);
}
