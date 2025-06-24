package com.example.studentservice.service;

import com.example.studentservice.entity.Student;
import com.example.studentservice.exception.StudentNotFoundException;

import java.util.List;

public interface StudentServiceImpl extends CourseServiceImpl {

    Student getStudentById(int id) throws StudentNotFoundException;
    List<Student> getAllStudents();
    Student createStudent(Student student);
    Student updateStudent(Student student);
    boolean deleteStudentById(int id) throws StudentNotFoundException;
}
