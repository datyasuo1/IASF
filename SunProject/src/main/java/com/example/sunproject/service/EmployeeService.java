package com.example.sunproject.service;

import com.example.sunproject.entity.Employees;
import com.example.sunproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employees> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employees> findById(String id){
        return employeeRepository.findById(id);
    }
    public Employees save(Employees employees) {
        return employeeRepository.save(employees);
    }

    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }
}
