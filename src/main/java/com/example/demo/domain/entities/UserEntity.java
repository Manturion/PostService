package com.example.demo.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Objects;

@Entity
@Data
@Table(name = "User", schema = "public", catalog = "posts")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "firstName", nullable = false, length = -1)
    private String firstName;
    @Basic
    @Column(name = "lastName", nullable = false, length = -1)
    private String lastName;
    @Basic
    @Column(name = "username", nullable = false, length = -1)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<PostEntity> postsById;

}
