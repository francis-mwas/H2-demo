package com.fram.h2project.controllers;

import com.fram.h2project.entity.Department;
import com.fram.h2project.errors.DepartmentNotFoundException;
import com.fram.h2project.service.DepartmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentServiceImpl departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("ÏT")
                .departmentCode("IT-001")
                .departmentAddress("Juja")
                .departmentId(1L)
                .build();
    }



    @Test
    void createDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("IT")
                .departmentCode("IT-001")
                .departmentAddress("Juja")
                .build();
        Mockito.when(departmentService.createDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/api/v1/departments")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "  \"departmentName\": \"IT\",\n" +
                        "  \"departmentCode\": \"IT-001\",\n" +
                        "  \"departmentAddress\": \"Juja\"\n" +
                        "\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(get("/api/v1/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.departmentName").
                                value(department.getDepartmentName()));

    }
}