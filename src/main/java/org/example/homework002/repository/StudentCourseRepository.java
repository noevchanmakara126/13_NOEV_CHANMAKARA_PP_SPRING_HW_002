package org.example.homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.model.entity.Course;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Results(id = "studentcourseMapper",value = {
            @Result(property = "id",column = "course_id"),
            @Result(property = "name",column = "course_name"),
            @Result(property = "instructor",column = "instructor_id",one = @One(select = "org.example.homework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
           SELECT * FROM student_course_tb bc INNER JOIN course_tb c
           ON bc.course_id = c.course_id
           WHERE student_id = #{id};
       
       """)
    List<Course> getAllCourseByStudentId (Long id);


    @Insert("""
        INSERT INTO student_course_tb VALUES (#{stuId},#{courseId})
        
        """)

    void saveStudentCouese(Long stuId,Long courseId);
}
