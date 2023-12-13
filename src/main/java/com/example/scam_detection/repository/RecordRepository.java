package com.example.scam_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scam_detection.entity.Record;

public interface RecordRepository extends JpaRepository<Record, Integer>{
    
}
