package com.example.courseservice.service;

import com.example.courseservice.entity.Course;
import com.example.courseservice.exception.CourseNotFoundException;

import java.util.List;

public interface CourseServiceImpl {

    Course getCourseById(int id) throws CourseNotFoundException;
    List<Course> getAllCourses();
    Course createCourse(Course course);
    Course updateCourse(Course course);
    boolean deleteCourseById(int id) throws CourseNotFoundException;
}
