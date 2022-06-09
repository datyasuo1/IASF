package com.example.sunproject.repository;

import com.example.sunproject.entity.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employees,String> {
}
