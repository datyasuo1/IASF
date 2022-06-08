package com.example.hello_spring.controller;

import com.example.hello_spring.entity.Student;
import com.example.hello_spring.repository.StudentRepository;
import com.example.hello_spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

/**
 * http://localhost:8080/api/v1/students |GET| return list student
 * http://localhost:8080/api/v1/students |POST| create new student
 * http://localhost:8080/api/v1/students/1 |DELETE| delete list student
 * http://localhost:8080/api/v1/students/1 |GET| find by id
 * http://localhost:8080/api/v1/students/1 |PUT| update student
 *
 **/
@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    //CRUD
    @Autowired
    StudentService studentService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Student>> getList(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> crete(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalStudent.get());
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<Student> delete( @PathVariable String id){
        if (!studentService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        studentService.deleteById(id);
        return  ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Student> update(@PathVariable String id, @RequestBody Student student) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (!optionalStudent.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Student existStudent = optionalStudent.get();
        existStudent.setName(student.getName());
        existStudent.setAddress(student.getAddress());
        existStudent.setPhone(student.getPhone());
        return ResponseEntity.ok(studentService.save(existStudent));
    }

}
