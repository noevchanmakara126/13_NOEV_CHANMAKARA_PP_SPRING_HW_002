package org.example.homework002.service;

import org.example.homework002.model.entity.Course;
import org.example.homework002.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course saveCourse(CourseRequest request);

    Course getCourseById(Long id);

    Course updateCourseById(Long id, CourseRequest request);

    Course deleteCourseById(Long id);
}
