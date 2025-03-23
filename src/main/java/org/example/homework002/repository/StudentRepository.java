package org.example.homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.model.entity.Student;
import org.example.homework002.request.StudentRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface StudentRepository {

    @Results(id = "studentMapper", value =
            {@Result(property = "id", column = "stu_id"),
                    @Result(property = "name",column = "stu_name"),
                    @Result(property = "phone",column = "phone_num"),
                    @Result(property = "courses",column = "stu_id",many = @Many(
                            select = "org.example.homework002.repository.StudentCourseRepository.getAllCourseByStudentId"
                    ))
            })

    @Select("""
            SELECT * FROM student_tb ;
""")
    List<Student> getAllStudents();

    @ResultMap("studentMapper")
    @Select("""
   INSERT INTO student_tb VALUES (default,#{req.name},#{req.email},#{req.phone})
   RETURNING *;

""")
    Student saveStudent(@Param("req") StudentRequest request);
    @ResultMap("studentMapper")
    @Select("""
SELECT * FROM student_tb WHERE stu_id = #{id};
""")
    Student getStudentByID(Long id);


    @Select("""
        DELETE  FROM student_tb WHERE stu_id = #{id};
""")

    List<Student> deleteStudentById(Long id);
    @ResultMap("studentMapper")
    @Select(""" 
    UPDATE student_tb SET stu_name = #{req.name},email = #{req.email},phone_num = #{req.phone} 
    WHERE stu_id = #{id}
""")
    Student updateStudentById(Long id,@Param("req") StudentRequest request);
}
