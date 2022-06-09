package com.example.sunproject.controller;


import com.example.sunproject.entity.Employees;
import com.example.sunproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employees")
@CrossOrigin(value = "*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Employees>> getList(){
        return ResponseEntity.ok(employeeService.findAll());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employees> crete(@RequestBody Employees employees) {
        return ResponseEntity.ok(employeeService.save(employees));
    }


    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<Employees> optionalEmployees = employeeService.findById(id);
        if (optionalEmployees.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalEmployees.get());
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<Employees> delete( @PathVariable String id){
        if (!employeeService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        employeeService.deleteById(id);
        return  ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Employees> update(@PathVariable String id, @RequestBody Employees employees) {
        Optional<Employees> optionalEmployees = employeeService.findById(id);
        if (!optionalEmployees.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Employees existEployees =optionalEmployees.get();
        existEployees.setId(employees.getId());
        existEployees.setName(employees.getName());
        existEployees.setWage(employees.getWage());
        return ResponseEntity.ok(employeeService.save(existEployees));
    }
}
