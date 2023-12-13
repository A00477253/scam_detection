package com.example.scam_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scam_detection.entity.Scam;

public interface ScamRepository extends JpaRepository<Scam, Integer>{
    
}