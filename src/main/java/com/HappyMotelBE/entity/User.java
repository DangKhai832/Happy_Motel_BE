package com.HappyMotelBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,name = "username")
    private String username;

    @Column(nullable = false,name = "password")
    private String password;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "realName")
    private String realName;

    @Column(nullable = false, unique = true,name = "email")
    private String email;

    private int gender;

    private Date createTime;

    private Date updateTime;

    private int isDelete;
}
