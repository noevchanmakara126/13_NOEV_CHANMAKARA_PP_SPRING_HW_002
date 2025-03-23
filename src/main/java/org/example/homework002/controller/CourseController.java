package org.example.homework002.controller;
import org.example.homework002.model.entity.Course;
import org.example.homework002.request.CourseRequest;
import org.example.homework002.respone.CourseRespone;
import org.example.homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public ResponseEntity<CourseRespone<List<Course>>>  getAllCourses(){
        CourseRespone<List<Course>> respone = new CourseRespone<>("Get all course Successfully",courseService.getAllCourses(), HttpStatus.OK, LocalDateTime.now());
        return ok(respone);
    }
    @PostMapping
    public ResponseEntity<CourseRespone<Course>>  saveCourse(@RequestBody CourseRequest request){
        CourseRespone<Course> respone = new CourseRespone<>("Save Course Successfully",courseService.saveCourse(request),HttpStatus.OK,LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(respone);
    }

    @GetMapping("/{course-id}")
    public Course getCourseById(@PathVariable("course-id") Long id) {
        Course course = courseService.getCourseById(id);
      return course;
    }
    @PutMapping("/{course-id}")
    public ResponseEntity<String> updateCourseById(@PathVariable("course-id" )Long id, @RequestBody CourseRequest request){
        Course course = courseService.updateCourseById(id,request);
        CourseRespone<Course> respone = new CourseRespone<>("Update Course Successfully",course,HttpStatus.OK,LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(respone.getMessage());
    }
    @DeleteMapping("/{course-id}")
    public ResponseEntity <CourseRespone<Course>> deleteCourseById(@PathVariable("course-id") Long id){
        courseService.deleteCourseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new CourseRespone<>("Delete Course with id "+id+" Successfully",HttpStatus.OK,LocalDateTime.now()));
    }
}
