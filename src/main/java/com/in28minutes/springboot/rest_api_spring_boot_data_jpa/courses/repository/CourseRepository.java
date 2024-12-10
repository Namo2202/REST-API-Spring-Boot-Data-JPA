package com.in28minutes.springboot.rest_api_spring_boot_data_jpa.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.rest_api_spring_boot_data_jpa.courses.bean.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
