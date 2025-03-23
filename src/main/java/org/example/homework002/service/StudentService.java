package org.example.homework002.service;

import org.example.homework002.model.entity.Student;
import org.example.homework002.request.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(StudentRequest request);

    Student getStudentByID(Long id);

    List<Student> deleteStudentById(Long id);

    Student updataStudentById(Long id, StudentRequest request);
}
