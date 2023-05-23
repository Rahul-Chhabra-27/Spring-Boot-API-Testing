package com.m2p.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepo {

    @Autowired
    private StudentUtils studentUtils;
    private List<Student> studentList = new ArrayList<>();

    StudentRepo() {
        studentList.add(new Student("Rahul Chhabra",1));
        studentList.add(new Student("Steve benjamin",2));
        studentList.add(new Student("John Doe",3));
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void saves(Student student) {
       Student getStudentById = this.studentUtils.findById(studentList,student.getId());
       if(getStudentById != null) {
            studentList.add(student);
       }
    }

    public Student getStudentById(Integer id) {
        return this.studentUtils.findById(studentList,id);
    }
}
