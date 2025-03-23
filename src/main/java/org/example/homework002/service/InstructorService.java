package org.example.homework002.service;

import org.example.homework002.model.entity.Instructor;
import org.example.homework002.request.InstructorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface InstructorService {
    List<Instructor> getAllInstructor();

    Instructor getInstructorById(Long id);

    Instructor saveInstructor(InstructorRequest request);

    Instructor updataInstructorById(Long id, InstructorRequest request);

    Instructor deleteInstructorById(Long id);
}
