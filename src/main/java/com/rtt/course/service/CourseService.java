package com.rtt.course.service;

import com.rtt.course.dto.request.CourseRequest;
import com.rtt.course.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse(CourseRequest request);
    List<CourseResponse> getAllCourses();
}