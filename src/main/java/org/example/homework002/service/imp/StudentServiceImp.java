package org.example.homework002.service.imp;

import org.example.homework002.exception.NotFoundException;
import org.example.homework002.model.entity.Student;
import org.example.homework002.repository.StudentCourseRepository;
import org.example.homework002.repository.StudentRepository;
import org.example.homework002.request.StudentRequest;
import org.example.homework002.respone.StudentRespone;
import org.example.homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;
    public StudentServiceImp(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public List<Student> getAllStudents() {
           List<Student>  student = studentRepository.getAllStudents();
           if ( student.isEmpty() ){
               throw new NotFoundException("Don't Have Any Student");
           }
        return studentRepository.getAllStudents();
    }

    @Override
    public Student saveStudent(StudentRequest request) {
        Student stundent = studentRepository.saveStudent(request);
            for (Long courseID : request.getCourses()){
                studentCourseRepository.saveStudentCouese(stundent.getId(),courseID);

            }
            if(stundent == null){
                throw new NotFoundException("Dont't Have Student");
            }
        return getStudentByID(stundent.getId());
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentRepository.getStudentByID(id);
    }

    @Override
    public List<Student> deleteStudentById(Long id) {
       if (getStudentByID(id) == null){
           throw new NotFoundException("This student doesn't Exist");
       }
        return studentRepository.deleteStudentById(id);
    }

    @Override
    public Student updataStudentById(Long id, StudentRequest request) {
        return studentRepository.updateStudentById(id,request);
    }
}
