package com.example.scam_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scam_detection.entity.EmailRecord;
import com.example.scam_detection.entity.EmailRecordId;

public interface EmailRecordRepository extends JpaRepository<EmailRecord, EmailRecordId>{
    
}