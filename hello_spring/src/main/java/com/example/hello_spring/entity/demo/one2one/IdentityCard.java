package com.example.hello_spring.entity.demo.one2one;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "identityCard")
public class IdentityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto

    private int id;
    private String fullname;
    private String gender;
}
