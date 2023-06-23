package com.m2p.Student;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    @Test
    void shouldGetStudents() {
        // Arrange..
        Student student = new Student("Anni",1);
        Student student1 = new Student("Ax",2);

        // Act...
        when(studentRepo.findAll()).thenReturn(Arrays.asList(student,student1));
        List<Student> students = this.studentRepo.findAll();

        // Assertions...
        Assertions.assertThat(students).isNotNull();
        Assertions.assertThat(students.size()).isEqualTo(2);
    }

    @Test
    void ShouldSaveStudent() {
        // Arrange..
        Student student = new Student("Anni",1);

        // Act...
        when(studentRepo.save(student)).thenReturn(student);
        Student savedStudent = this.studentRepo.save(student);

        // Assertions...
        Assertions.assertThat(savedStudent).isNotNull();
        Assertions.assertThat(student.getName()).isEqualTo(savedStudent.getName());
    }

    @Test
    void shouldGetStudentById() {
        // Arrange..
        Student student = new Student("Anni",1);

        // Act...
        when(studentRepo.findById(student.getId())).thenReturn(Optional.of(student));
        Optional<Student> student1 = this.studentRepo.findById(student.getId());

        // Assertions..
        Assertions.assertThat(student1).isNotNull();
        Assertions.assertThat(student1.isPresent()).isTrue();
        Assertions.assertThat(student1.get().getName()).isEqualTo(student.getName());
    }
}