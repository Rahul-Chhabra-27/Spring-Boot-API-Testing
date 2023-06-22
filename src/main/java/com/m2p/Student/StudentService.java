package com.m2p.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {


    @Autowired
    private StudentRepo studentRepo;


    public List<Student> getStudents(){
        return this.studentRepo.findAll();
    };

    public Student saveStudent(Student student) {
        return this.studentRepo.save(student);
    }

    public Optional<Student> getStudent(Integer id) {
        return this.studentRepo.findById(id);
    }
}
