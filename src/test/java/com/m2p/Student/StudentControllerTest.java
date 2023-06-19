package com.m2p.Student;

import ch.qos.logback.core.net.ObjectWriter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test

    void shouldGetALlTheStudentList() throws Exception{

        when(studentService.getStudents()).thenReturn(Arrays.asList(new Student("Utkarsh",20)));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(status().isOk()) // default 200
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(new Student("Utkarsh",20)))));

    }
    @Test
    void shouldSaveAStudent() throws Exception {
        Student student = new Student("Ram",5);
        when(studentService.saveStudent(student)).thenReturn(student);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isCreated());
    }
    @Test
    void shouldReturnAStudentById() throws Exception {
        // given...
        int studentId = 100;
        Student student = new Student("rush",studentId);

        when(studentService.getStudent(studentId)).thenReturn(student);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/student/{id}",studentId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }
}

