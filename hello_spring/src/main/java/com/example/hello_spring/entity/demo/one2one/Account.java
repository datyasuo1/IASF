package com.example.hello_spring.entity.demo.one2one;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto

    private int id;
    private String username;
    private String password;
    @OneToOne
    @JoinColumn(name = "identityCardId")
    private IdentityCard identityCard;
}
