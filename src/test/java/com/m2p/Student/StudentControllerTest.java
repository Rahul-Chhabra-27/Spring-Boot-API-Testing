package com.m2p.Student;

import ch.qos.logback.core.net.ObjectWriter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
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


    DemoCalculator demo = new DemoCalculator();

    @Test
    void shouldGetALlTheStudentList() throws Exception{

//        when(studentService.getStudents()).thenReturn(Arrays.asList(new Student("Utkarsh",1)));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
//                .andExpect(status().isOk()) // default 200
//                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(new Student("Utkarsh",1)))));
//
//

    }

    @Test
    void itShouldAddTwoNumbers() {

        int a = 20;
        int b = 30;

        int result = demo.addTwoNumbers(a,b);

        assertThat(result).isEqualTo(50);
    }
    class DemoCalculator {
        int addTwoNumbers(int a,int b) {
            return a + b;
        }
    }
}

