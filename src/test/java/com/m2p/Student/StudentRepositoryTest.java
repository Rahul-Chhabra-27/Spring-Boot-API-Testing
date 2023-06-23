package com.m2p.Student;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void shouldSaveTheStudent() {
        // Arrange...
        Student student = new Student("Rahul",1);

        // Act....
        Student savedStudent = this.studentRepo.save(student);

        // Assertion...
        Assertions.assertThat(savedStudent).isNotNull();
        Assertions.assertThat(student.getName()).isEqualTo(savedStudent.getName());
    }
    @Test
    public void shouldReturnTheListOfStudents() {
        // Arrange..
        Student student1 = new Student("Pikachu",1);
        Student student2 = new Student("Anime",20);


        // Act..
        this.studentRepo.save(student1);
        this.studentRepo.save(student2);

        List<Student> students = this.studentRepo.findAll();

        // Assertion..
        Assertions.assertThat(students).isNotNull();
        Assertions.assertThat(students.size()).isEqualTo(2);
    }
    @Test
    public void shouldGetTheExistingStudentById() {
        // Arrange..
        Student student = new Student("Anni",1);

        // Act..
        this.studentRepo.save(student);
        Optional<Student> savedStudent = this.studentRepo.findById(student.getId());

         // Assertions..
        Assertions.assertThat(savedStudent.isPresent()).isTrue();
        Assertions.assertThat(savedStudent.get().getId()).isEqualTo(1);
        Assertions.assertThat(savedStudent).isNotNull();
    }
    @Test
    public void shouldReturnFalseWhenUserDoesNotExist() {

        // Arrange..
        Student student  = new Student("test",1);

        // Act..
        this.studentRepo.save(student);
        Optional<Student> student1 = this.studentRepo.findById(100);

        // Assertion..
        Assertions.assertThat(student1).isNotNull();
        Assertions.assertThat(student1.isPresent()).isFalse();
    }
}
