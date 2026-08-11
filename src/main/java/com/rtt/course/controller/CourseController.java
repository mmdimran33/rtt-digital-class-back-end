package com.rtt.course.controller;

import com.rtt.common.ApiResponse;
import com.rtt.constants.ResponseCode;
import com.rtt.course.dto.request.CourseRequest;
import com.rtt.course.dto.response.CourseResponse;
import com.rtt.course.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponse>> createCourse(
            @Valid @RequestBody CourseRequest request) {

        CourseResponse response =
                courseService.createCourse(request);

        ApiResponse<CourseResponse> apiResponse =
                new ApiResponse<>(
                        ResponseCode.SUCCESS,
                        "Course created successfully",
                        response
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseResponse>>> getAllCourses() {

        List<CourseResponse> courses = courseService.getAllCourses();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "000",
                        "Courses fetched successfully",
                        courses
                )
        );
    }
}
