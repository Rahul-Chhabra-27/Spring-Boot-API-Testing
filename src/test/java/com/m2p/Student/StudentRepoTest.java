package com.m2p.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepoTest {

    @Autowired
    private  StudentRepo underTest;
    @Test
    void getStudentList() {

    }

    @Test
    void saves() {


    }

    @Test
    void getStudentById() {
        // given..
        Student student = new Student("Amit",20);
        underTest.saves(student);

        // when
        Student result =  underTest.getStudentById(1);

        // then.
        assertThat(result).isEqualTo(student);
    }
}