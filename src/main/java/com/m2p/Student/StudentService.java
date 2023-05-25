package com.m2p.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getStudents(){
        return studentRepo.getStudentList();
    };

    public Student saveStudent(Student student) {
        return this.studentRepo.saves(student);
    }

    public Student getStudent(Integer id) {
        return studentRepo.getStudentById(id);
    }
}
