package org.example.homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.model.entity.Course;
import org.example.homework002.request.CourseRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseRepository {
    @Results(id = "courseMapper" ,value = {
            @Result(property = "id",column = "course_id"),
            @Result(property = "name",column = "course_name"),
            @Result(property = "instructor",column = "instructor_id" ,one = @One(select = "org.example.homework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
      SELECT * FROM course_tb 
      
      """)
    List<Course> getAllCourses();
@ResultMap("courseMapper")
    @Select("""
        INSERT INTO course_tb VALUES (default,#{req.name},#{req.description},#{req.instructorId})
        RETURNING *;
        """)
    Course saveCourse(@Param("req") CourseRequest request);


    @ResultMap("courseMapper")
    @Select("""
    SELECT * FROM course_tb WHERE course_id = #{id};
 
    """)
    Course getCourseById(Long id);


    @ResultMap("courseMapper")
    @Select("""
    UPDATE course_tb SET course_name =#{req.name}, description = #{req.description}, 
    instructor_id = #{req.instructorId} 
    WHERE course_id = #{id}
    RETURNING *;
    """)
    Course updateCourseById(Long id,@Param("req") CourseRequest request);


    @ResultMap("courseMapper")
    @Select("""
    DELETE FROM course_tb WHERE course_id = #{id}
    """)
    Course deleteCourseById(Long id);
}
