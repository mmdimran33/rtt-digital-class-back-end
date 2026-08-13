package com.rtt.course.repository;

import com.rtt.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameIn(List<String> names);
}