package com.in28minutes.springboot.rest_api_spring_boot_data_jpa.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.rest_api_spring_boot_data_jpa.courses.bean.Course;
import com.in28minutes.springboot.rest_api_spring_boot_data_jpa.courses.repository.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository repository;

	// http://localhost:8080/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return repository.findAll();
	}

	// http://localhost:8080/courses/{id}
	@GetMapping("/courses/{id}")
	public Course getCourseDetails(@PathVariable long id) {
		Optional<Course> course = repository.findById(id);
		if (course.isEmpty()) {
			throw new RuntimeException("Course not found with id " + id);
		}
		return course.get();
	}

	// http://localhost:8080/courses
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
	}

	// http://localhost:8080/courses/{id}
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id, @RequestBody Course course) {
		repository.save(course);
	}

	// http://localhost:8080/courses/{id}
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
		repository.deleteById(id);
	}

}
