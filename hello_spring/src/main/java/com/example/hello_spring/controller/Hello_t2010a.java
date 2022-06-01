package com.example.hello_spring.controller;

import com.example.hello_spring.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/hello")
public class Hello_t2010a {
    @RequestMapping(path = "say" , method = RequestMethod.GET)
    public String say(){
        return "Hello world";
    }

    @RequestMapping(path = "talk",method = RequestMethod.GET)
    public String talk(){
        return "talk hello world";
    }
    @RequestMapping(path = "student",method = RequestMethod.GET)
    public Student getStudent(){
        return Student.builder()
                .id("1A100")
                .name("hoha")
                .phone("011112")
                .address("Hanoi")
                .build();
    }
}
