package org.example.homework002.controller;
import org.example.homework002.model.entity.Student;
import org.example.homework002.request.StudentRequest;
import org.example.homework002.respone.StudentRespone;
import org.example.homework002.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("api/v1/students")
public class StudentController {
   private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<StudentRespone<List<Student>>> getAllStudents (){
        StudentRespone<List<Student>> respone = new StudentRespone<>(
                "All students have been successfully fetched",service.getAllStudents(), HttpStatus.OK
               ,
               LocalDateTime.now()
        );
        return ResponseEntity.ok(respone);
    }
    @GetMapping("/{student-id}")
    public ResponseEntity<StudentRespone<Student>> getStudentById (@PathVariable("student-id")  Long id){

        StudentRespone<Student> respone1 = new StudentRespone<>("Get Student wtih id "+id+" Successfully",service.getStudentByID(id),HttpStatus.OK,LocalDateTime.now()
        );
        return ResponseEntity.ok(respone1);
    }
    @PostMapping
    public ResponseEntity<StudentRespone<Student>>  saveStudent(@RequestBody StudentRequest request){
        StudentRespone<Student> respone = new StudentRespone<>("Save Student Successfully",service.saveStudent(request),HttpStatus.OK,LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(respone);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<StudentRespone<List<Student>> >  deleteStudentById(@PathVariable("student-id") Long id ){
        StudentRespone<List<Student>> respone = new StudentRespone<>("Delete Student with Id "+ id +" Successfully",service.deleteStudentById(id),HttpStatus.OK,LocalDateTime.now());
        return ResponseEntity.ok(respone);
    }
    @PutMapping("/{student-id}")
    public ResponseEntity<StudentRespone<Student>>  updateStudentById(@PathVariable("student-id") Long id,@RequestBody StudentRequest request){
        StudentRespone<Student> respone = new StudentRespone<>("Update Student with Id "+id+" Successfully",service.updataStudentById(id,request),HttpStatus.OK,LocalDateTime.now());
        return ResponseEntity.ok(respone);
    }
}
