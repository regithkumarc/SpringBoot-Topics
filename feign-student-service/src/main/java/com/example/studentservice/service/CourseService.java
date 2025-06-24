package com.example.studentservice.service;

import com.example.studentservice.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private RestTemplate restTemplate;

    String BASE_URL = "http://localhost:8088/course";

    public Course getCourseById(int id) {
        String url = BASE_URL + "/" + id;
        ResponseEntity<Course> responseEntity = restTemplate.getForEntity(url,Course.class);
        return responseEntity.getBody();
    }

    public List<Course> getAllCourses() {
        ResponseEntity<Course> responseEntity = restTemplate.getForEntity(BASE_URL,Course.class);
        return Arrays.asList(responseEntity.getBody() != null ? responseEntity.getBody() : null) ;
    }
}
