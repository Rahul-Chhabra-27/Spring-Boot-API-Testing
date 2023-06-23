package com.m2p.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// inversion of control
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Integer id){
        Optional<Student> student = studentService.getStudent(id);
        if(student.isPresent()) {
            return new ResponseEntity<>(student,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student response = studentService.saveStudent(student);
        if(response != null) {
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
