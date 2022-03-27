package com.fram.h2project.service;

import com.fram.h2project.entity.Department;
import com.fram.h2project.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DerpatmentService derpatmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Juja")
                .departmentCode("IT-001")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Should get a department by name if the name exist")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){
        String departmentName = "IT";

        Department found = derpatmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
        assertEquals(departmentName, found.getDepartmentName());
    }
}