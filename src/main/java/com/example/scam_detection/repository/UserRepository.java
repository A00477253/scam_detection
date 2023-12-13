package com.example.scam_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scam_detection.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
