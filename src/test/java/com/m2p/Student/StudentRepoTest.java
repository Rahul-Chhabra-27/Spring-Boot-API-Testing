package com.m2p.Student;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class StudentRepoTest {

    @Autowired
    private  StudentRepo studentRepo;

    @Test
    void shouldSaveTheStudent() {

        // Acquire..
        Student student = new Student("Sam",10);

        // Act..
        Student savedStudent = studentRepo.saves(student);

        // Assertion..
        Assertions.assertThat(savedStudent).isNotNull();
        Assertions.assertThat(savedStudent.getId()).isGreaterThan(0);

    }
    @Test
    void shouldGetAllTheStudents() {
        // Acquire..
        Student student = new Student("Sam",15);
        Student student2 = new Student("Akki",20);

        // Act..
        studentRepo.saves(student);
        studentRepo.saves(student2);

        List<Student> students = studentRepo.getStudentList();

        // Assertion..
        Assertions.assertThat(students).isNotNull();
        Assertions.assertThat(students.size()).isGreaterThan(2);
    }
    @Test
    void shouldGetTheIdOfTheStudent() {
        // Acquire..
        Student student = new Student("sam",4);

        // Act
        studentRepo.saves(student);
        Student savedStudent = studentRepo.getStudentById(student.getId());

        // Assertion..
        Assertions.assertThat(student).isEqualTo(savedStudent);
        Assertions.assertThat(student.getId()).isGreaterThan(0);
    }
}