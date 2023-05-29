package com.m2p.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class StudentService {


    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepository) {
        studentRepo = studentRepository;
    }

    public List<Student> getStudents(){
        return this.studentRepo.getStudentList();
    };

    public Student saveStudent(Student student) {
        return this.studentRepo.saves(student);
    }

    public Student getStudent(Integer id) {
        return studentRepo.getStudentById(id);
    }
}
