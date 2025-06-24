package com.example.courseservice.controller;

import com.example.courseservice.entity.Course;
import com.example.courseservice.exception.CourseNotFoundException;
import com.example.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getName")
    public String getName() {
        return "Getting the CourseController";
    }

    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) throws CourseNotFoundException {
        Course course = courseService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses() throws CourseNotFoundException {
        List<Course> courseList = courseService.getAllCourses();
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @PostMapping("/createCourse")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) throws CourseNotFoundException {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PutMapping("/updateCourse")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) throws CourseNotFoundException {
        Course updatedCourse = courseService.updateCourse(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCourseById/{id}")
    public ResponseEntity<Boolean> deleteCourseById(@PathVariable int id) throws CourseNotFoundException {
        boolean deletedStatus = courseService.deleteCourseById(id);
        return new ResponseEntity<>(deletedStatus,HttpStatus.OK);
    }
}
