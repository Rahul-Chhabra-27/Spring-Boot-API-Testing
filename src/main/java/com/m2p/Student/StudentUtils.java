package com.m2p.Student;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentUtils {
    
    public Student findById(List<Student> studentList, Integer id) {
        
        int n = studentList.size();
        
        for(int i = 0; i < n; i++) {
            Student currentStudent = studentList.get(i);
            
            if(currentStudent.getId() == id) {
                return currentStudent;
            }
        }
        return null;
    }
}
