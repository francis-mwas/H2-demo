package com.fram.h2project.controllers;

import com.fram.h2project.entity.Department;

import com.fram.h2project.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/departments")
public class DepartmentController {
  @Autowired
  private DepartmentServiceImpl departmentService;

//  adding logger to your spring boot application
  private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    //@Valid help us to invoke validation that has been enforced in our entity
    @PostMapping()
    public Department createDepartment( @Valid  @RequestBody Department department){
        LOGGER.info("Inside createDepartment method of DepartmentController"+ department);
       return departmentService.createDepartment(department);
    }
    @GetMapping
  public List<Department> fetchDepartments(){
        LOGGER.info("Inside fetchDepartments method of DepartmentController");
      return departmentService.getDepartments();
    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted sucessfully!";
    }
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
    @GetMapping("/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return  departmentService.fetcDepartmentByName(departmentName);
    }
}
