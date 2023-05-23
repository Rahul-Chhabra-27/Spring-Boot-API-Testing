package com.m2p.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

// inversion of control
@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(Integer id, String name){
        return new ResponseEntity<>(studentService.getStudents(id,name),HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public void getAStudent(Integer id){
        System.out.println("Id " + id);
        studentService.getStudent(id);
//        return new ResponseEntity<>(studentService.getStudent(),HttpStatus.OK);

    }

    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        System.out.println(student.getName());
        studentService.saveStudent(student);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
}

// solve this without tdd
// solve shooting game with tdd