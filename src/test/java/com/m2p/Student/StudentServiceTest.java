package com.m2p.Student;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks private StudentService studentService;

    @Test
    void canGetAllTheStudents() {
       // Act
        Student student = new Student("Rahul",27);
        Student student2 = new Student("PW",100);

        // Acquire..
        when(studentRepo.getStudentList()).thenReturn(Arrays.asList(student,student2)); // Mocking things...
        List<Student> students = studentService.getStudents();

        // Acquire..
        Assertions.assertThat(students).isNotNull();
        Assertions.assertThat(students.size()).isEqualTo(2);

    }
    @Test
    void canAddTheStudent() {
        // Act..
        Student student = new Student("Amit",10);

        // Acquire..
        when(studentRepo.saves(student)).thenReturn(student);
        Student savedStudent = studentService.saveStudent(student);

        // Assertion..
        Assertions.assertThat(savedStudent).isNotNull();
        Assertions.assertThat(savedStudent.getId()).isEqualTo(10);

    }

    @Test
    void getStudent() {
       // Act..
        Student student = new Student("Rahul",27);

        // Acquire...
        when(studentRepo.getStudentById(student.getId())).thenReturn(student);
        Student fetchedStudent = studentService.getStudent(student.getId());

        // Assertion..
        Assertions.assertThat(fetchedStudent).isNotNull();
        Assertions.assertThat(fetchedStudent.getId()).isEqualTo(student.getId());

    }
}