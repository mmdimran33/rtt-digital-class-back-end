package com.rtt.course.service.impl;

import com.rtt.course.dto.request.CourseRequest;
import com.rtt.course.dto.response.CourseResponse;
import com.rtt.course.entity.Course;
import com.rtt.course.repository.CourseRepository;
import com.rtt.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseResponse createCourse(CourseRequest request) {

        Course course = Course.builder()
                .name(request.name())
                .fees(request.fees())
                .build();

        Course savedCourse = courseRepository.save(course);

        return new CourseResponse(
                savedCourse.getId(),
                savedCourse.getName(),
                savedCourse.getFees()
        );
    }

    @Override
    public List<CourseResponse> getAllCourses() {

        return courseRepository.findAll()
                .stream()
                .map(course -> new CourseResponse(
                        course.getId(),
                        course.getName(),
                        course.getFees()
                ))
                .toList();
    }
}
