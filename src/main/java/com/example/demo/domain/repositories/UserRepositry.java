package com.example.demo.domain.repositories;

import com.example.demo.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<UserEntity, Long> {
}
