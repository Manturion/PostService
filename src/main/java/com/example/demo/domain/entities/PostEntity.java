package com.example.demo.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "Post", schema = "public", catalog = "posts")
public class PostEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "category", nullable = false, length = -1)
    private String category;
    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;
    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity userByUserId;
}
