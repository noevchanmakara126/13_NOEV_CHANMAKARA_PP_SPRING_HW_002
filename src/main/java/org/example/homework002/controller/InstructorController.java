package org.example.homework002.controller;

import org.example.homework002.model.entity.Instructor;
import org.example.homework002.request.InstructorRequest;
import org.example.homework002.respone.InstructorRespone;
import org.example.homework002.respone.StudentRespone;
import org.example.homework002.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
  private final InstructorService instructorService;
  public InstructorController(InstructorService instructorService){
      this.instructorService=instructorService;
  }
    @GetMapping
    public ResponseEntity<InstructorRespone<List<Instructor>>>  getAllInstructor (){
        InstructorRespone<List<Instructor>> respone = new InstructorRespone<>("Get all Instructor Succesfully",instructorService.getAllInstructor(), HttpStatus.OK, LocalDateTime.now());
        return ResponseEntity.ok(respone);
    }

  @GetMapping("/{instructor-id}")
    public ResponseEntity<InstructorRespone<Instructor>>  getInstructorById(@PathVariable("instructor-id") Long id){
      InstructorRespone<Instructor> respone = new InstructorRespone<>("Get Instructor with id "+id+"Successfully",instructorService.getInstructorById(id),HttpStatus.OK,LocalDateTime.now());
      return ResponseEntity.ok(respone);
  }

  @PostMapping
  public ResponseEntity<InstructorRespone<Instructor>>  saveInstructor (@RequestBody InstructorRequest request){
    InstructorRespone<Instructor> respone = new InstructorRespone<>("Save New Instructor Successfully",instructorService.saveInstructor(request),HttpStatus.OK,LocalDateTime.now());
    return ResponseEntity.ok(respone);
  }
  @PutMapping("/{instructor-id}")
  public ResponseEntity<InstructorRespone<Instructor>>  updateInstructorById(@PathVariable("instructor-id") Long id , @RequestBody InstructorRequest request){
    InstructorRespone<Instructor> respone = new InstructorRespone<>("Update Instructor with id "+id+" Successfully",instructorService.updataInstructorById(id,request),HttpStatus.OK,LocalDateTime.now());
    return ResponseEntity.ok(respone);
  }
  @DeleteMapping("/{instructor-id}")
  public ResponseEntity<InstructorRespone<Instructor>>  deleteInstructorById(@PathVariable("instructor-id") Long id){
    InstructorRespone<Instructor> respone = new InstructorRespone<>("Delete Instructor with id "+id+" Succesfully",instructorService.deleteInstructorById(id),HttpStatus.OK,LocalDateTime.now());
    return ResponseEntity.ok(respone);
  }

}
