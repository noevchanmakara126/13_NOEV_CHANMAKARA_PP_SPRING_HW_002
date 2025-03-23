package org.example.homework002.repository;


import org.apache.ibatis.annotations.*;
import org.example.homework002.model.entity.Instructor;
import org.example.homework002.request.InstructorRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper

public interface InstructorRepository {


@Results(id = "instructorMapper" , value = {
        @Result(property = "id",column = "instructor_id"),
        @Result(property = "name",column = "instuctor_name"),
})
    @Select("""
            SELECT * FROM instructors_tb; 
   
            """)
    List<Instructor> getAllInstructor();

    @ResultMap("instructorMapper")
    @Select("""
        SELECT * FROM instructors_tb 
        WHERE instructor_id = #{id};
        
        """)
    Instructor getInstructorById(Long id);
    @ResultMap("instructorMapper")
    @Select("""
    INSERT INTO instructors_tb  VALUES (default,#{req.name},#{req.email})
    RETURNING * ;
    """)
    Instructor saveInstructor(@Param("req") InstructorRequest request);
    @ResultMap(("instructorMapper"))
    @Select("""
            UPDATE instructors_tb SET instuctor_name = #{req.name}, email = #{req.email} WHERE instructor_id = #{id};

    """)
    Instructor updateInstructorById(Long id,@Param("req") InstructorRequest request);

    @ResultMap("instructorMapper")
    @Select("""
            DELETE FROM instructors_tb WHERE instructor_id = #{id};
        """)
    Instructor deleteInstructorById(Long id);
}
