package com.example.studentservice.client;

import com.example.studentservice.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "course-client", url = "http://localhost:8088/course")
public interface CourseClient {

    @GetMapping
    List<Course> getAllCourses();

    @GetMapping("getCourseById/{id}")
    Course getCourseById(int id);
}
