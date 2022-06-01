package com.example.hello_spring.controller;

import com.example.hello_spring.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * http://localhost:8080/api/v1/students |GET| return list student
 * http://localhost:8080/api/v1/students |POST| create new student
 * http://localhost:8080/api/v1/students/1 |DELETE| delete list student
 * http://localhost:8080/api/v1/students/1 |GET| find by id
 * http://localhost:8080/api/v1/students/1 |PUT| update student
 *
 **/

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    //CRUD
    private static List<Student> list ;
    public StudentController(){
        list = new ArrayList<>();
        list.add(Student.builder().id("AB1").name("Dat").phone("01111554").address("Hanoi").build());
        list.add(Student.builder().id("AB2").name("Hai").phone("01111554").address("Hanoi").build());
        list.add(Student.builder().id("AB3").name("Hong").phone("01111554").address("Hanoi").build());
        list.add(Student.builder().id("AB4").name("Hoa").phone("01111554").address("Hanoi").build());
        list.add(Student.builder().id("AB5").name("Nhi").phone("01111554").address("Hanoi").build());
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll(){
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save ( @RequestBody Student student){
        list.add(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Student findById ( @PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getId().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return null;
        }
        return list.get(foundIndex);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean deleteById ( @PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getId().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return false;
        }
        list.remove(foundIndex);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Student update ( @PathVariable String id, @RequestBody Student updateStudent){
        int foundIndex = -1;
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getId().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1){
            return null;
        }
        Student existing = list.get(foundIndex);
        existing.setId(updateStudent.getId());
        existing.setName(updateStudent.getName());
        existing.setPhone(updateStudent.getPhone());
        existing.setAddress(updateStudent.getAddress());
        return existing;
    }
}
