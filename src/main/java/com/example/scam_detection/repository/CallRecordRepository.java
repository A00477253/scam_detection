package com.example.scam_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scam_detection.entity.CallRecord;
import com.example.scam_detection.entity.CallRecordId;

public interface CallRecordRepository extends JpaRepository<CallRecord, CallRecordId>{
    
}