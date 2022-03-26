package com.fram.h2project.service;


import com.fram.h2project.entity.Department;
import com.fram.h2project.errors.DepartmentNotFoundException;

import java.util.List;


public interface DerpatmentService {
    public Department createDepartment(Department department);
    public List<Department> getDepartments();
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;
    public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

   public Department fetcDepartmentByName(String departmentName);
}
