package com.m2p.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepo {

    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public Student saves(Student student) {

        Student isStudentAlreadyExist = this.getStudentById(student.getId());

        // checking if the student is already exist.....
        if(isStudentAlreadyExist != null) return null;

        // saving the student....
        this.studentList.add(student);

        // returning the student...
        return student;
    }

    public Student getStudentById(Integer id) {

        // getting the size of the list...........
        int n = studentList.size();

        // Iterating over the loop to check whether any student exist with sae id.
        for(int student = 0; student < n; student++) {
            Student currentStudent = studentList.get(student);

            if(currentStudent.getId() == id) {
                // returning the currentStudent...
                return currentStudent;
            }
        }
        // Means NO Student found with id as id.
        return null;
    }
}
