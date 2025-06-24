package com.example.studentservice.service;

import com.example.studentservice.entity.Course;

import java.util.List;

public interface CourseServiceImpl {
    List<Course> getAllCourses();
    Course getCourseById(int id);
}
