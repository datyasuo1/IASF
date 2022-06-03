package com.example.hello_spring.repository;

import com.example.hello_spring.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //dang lam viec vs db
public interface StudentRepository extends CrudRepository<Student, String> {
}
