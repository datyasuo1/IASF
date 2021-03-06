package com.example.hello_spring.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private String phone;
    private String address;
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
