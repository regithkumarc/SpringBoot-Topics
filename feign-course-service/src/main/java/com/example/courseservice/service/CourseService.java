package com.example.courseservice.service;

import com.example.courseservice.entity.Course;
import com.example.courseservice.exception.CourseNotFoundException;
import com.example.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService implements CourseServiceImpl {

    @Autowired
    private CourseRepository paymentRepository;

    @Override
    public Course getCourseById(int id) throws CourseNotFoundException {
        Optional<Course> optional = paymentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new CourseNotFoundException("Course not found this id : " + id);
        }
    }

    @Override
    public List<Course> getAllCourses() {
        return paymentRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
        course.setTransactionId(UUID.randomUUID().toString());
        course.setStatus("success");
        return paymentRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return paymentRepository.save(course);
    }

    @Override
    public boolean deleteCourseById(int id) throws CourseNotFoundException {
        Optional<Course> optional = paymentRepository.findById(id);
        if(optional.isPresent()) {
            paymentRepository.deleteById(id);
            return true;
        } else {
            throw new CourseNotFoundException("Course not found this id : " + id);
        }
    }
}
