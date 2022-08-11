package com.company.eshkon.userlogin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="USER_TABLE")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    private String name;
    @Column(name = "USERNAME", nullable = false)
    private String userName;
    private String password;
}
