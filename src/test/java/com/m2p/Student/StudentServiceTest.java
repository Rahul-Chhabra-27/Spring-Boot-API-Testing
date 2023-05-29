package com.m2p.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;
    private StudentService underTest;
    @BeforeEach
    void setUp() {
        underTest = new StudentService(studentRepo);
    }
    @Test
    void canGetAllTheStudents() {
        // When...
        underTest.getStudents();

        // Then...
        verify(studentRepo).getStudentList();
    }
    @Test
    void canAddTheStudent() {
        // given...
        Student student = new Student("Banggad billa",10);
        // When...
        underTest.saveStudent(student);

        // Then...
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(studentRepo).saves(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void getStudent() {
        // given...
        int studentId = 1;

        // when...

        underTest.getStudent(studentId);
        ArgumentCaptor<Integer> studentArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

        // Then..
        verify(studentRepo).getStudentById(studentArgumentCaptor.capture());
        int studentCapturedId = studentArgumentCaptor.getValue();

        assertThat(studentCapturedId).isEqualTo(studentId);
    }
}