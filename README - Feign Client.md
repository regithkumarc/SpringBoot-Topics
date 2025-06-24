Feign Client Config:

application.yml 

		<!-- Feign Client -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
		
--------------------------------------------------------------------------------

@FeignClient(name = "course-client", url = "http://localhost:8088/course")
public interface CourseClient {

    @GetMapping
    List<Course> getAllCourses();

    @GetMapping("getCourseById/{id}")
    Course getCourseById(int id);
}

--------------------------------------------------------------------------------

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

--------------------------------------------------------------------------------

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignStudentServiceApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignStudentServiceApplication.class, args);
	}

}

