package org.example.homework002.service.imp;
import org.example.homework002.exception.NotFoundException;
import org.example.homework002.model.entity.Course;
import org.example.homework002.repository.CourseRepository;
import org.example.homework002.request.CourseRequest;
import org.example.homework002.respone.CourseRespone;
import org.example.homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;
    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course>  getAllCourses() {
        List<Course> courses = courseRepository.getAllCourses();
        if (courses.isEmpty()){
            throw new NotFoundException("Don't Have Any Course");
        }
        return courseRepository.getAllCourses() ;

    }

    @Override
    public Course saveCourse(CourseRequest request) {
        return courseRepository.saveCourse(request);
    }

    @Override
    public Course getCourseById(Long id) {
        Course course = courseRepository.getCourseById(id);
        if (course == null){
            throw new NotFoundException("This Course Not found");
        }
        return course;
    }

    @Override
    public Course updateCourseById(Long id, CourseRequest request) {
//        Course course = courseRepository.updateCourseById(id,request);
        getCourseById(id);
        return courseRepository.updateCourseById(id,request);
    }

    @Override
    public Course deleteCourseById(Long id) {
          getCourseById(id);
        return courseRepository.deleteCourseById(id);
    }
}
