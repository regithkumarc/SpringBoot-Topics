package com.example.studentservice.controller;

import com.example.studentservice.entity.Student;
import com.example.studentservice.exception.StudentNotFoundException;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the StudentController";
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) throws StudentNotFoundException {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() throws StudentNotFoundException {
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws StudentNotFoundException {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws StudentNotFoundException {
        Student updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable int id) throws StudentNotFoundException {
        boolean deletedStatus = studentService.deleteStudentById(id);
        return new ResponseEntity<>(deletedStatus,HttpStatus.OK);
    }
}
