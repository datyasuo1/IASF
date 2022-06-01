package com.example.hello_spring.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class Student {
    private String id;
    private String name;
    private String phone;
    private String address;
}
