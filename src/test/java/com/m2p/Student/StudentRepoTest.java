package com.m2p.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class StudentRepoTest {

    @Autowired
    private  StudentRepo underTest;

    @Test
    void shouldCheckIfStudentIdExists() {
        // given..
        Student student = new Student("Amit",20);

        // Assuming that underTest,save() function works fine.
        underTest.saves(student);

        // when
        Student result =  underTest.getStudentById(20);

        // then.
        assertThat(result).isEqualTo(student);
    }
    @Test
    void shouldCheckIfStudentIdDoesNotExists() {
        // given student id, this id never exist in students list..
        int studentId = 100101;

        // when
        Student result =  underTest.getStudentById(studentId);

        // then.
        assertThat(result).isEqualTo(null);
    }
}