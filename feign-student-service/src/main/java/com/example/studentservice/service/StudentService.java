package com.example.studentservice.service;

import com.example.studentservice.client.CourseClient;
import com.example.studentservice.entity.Course;
import com.example.studentservice.entity.Student;
import com.example.studentservice.exception.StudentNotFoundException;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService implements StudentServiceImpl {

    @Autowired
    private StudentRepository studentRepository;

/*    @Autowired
    private CourseService courseService;*/

    @Autowired
    private CourseClient courseClient;

    @Override
    public Student getStudentById(int id) throws StudentNotFoundException {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new StudentNotFoundException("Student not found this id : " + id);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        student.setTransactionId(UUID.randomUUID().toString());
        student.setStatus("success");
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudentById(int id) throws StudentNotFoundException {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        } else {
            throw new StudentNotFoundException("Student not found this id : " + id);
        }
    }

    @Override
    public List<Course> getAllCourses() {
        return courseClient.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) {
        return courseClient.getCourseById(id);
    }
}
