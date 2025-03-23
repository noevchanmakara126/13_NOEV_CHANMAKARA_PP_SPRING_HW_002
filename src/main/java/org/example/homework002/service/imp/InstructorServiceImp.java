package org.example.homework002.service.imp;

import org.example.homework002.model.entity.Instructor;
import org.example.homework002.repository.InstructorRepository;
import org.example.homework002.request.InstructorRequest;
import org.example.homework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImp implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImp(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.getAllInstructor();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public Instructor saveInstructor(InstructorRequest request) {
        return instructorRepository.saveInstructor(request);
    }

    @Override
    public Instructor updataInstructorById(Long id, InstructorRequest request) {
        return instructorRepository.updateInstructorById(id,request);
    }

    @Override
    public Instructor deleteInstructorById(Long id) {
        return  instructorRepository.deleteInstructorById(id);
    }
}
