package com.example.scam_detection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.scam_detection.entity.Record;
import com.example.scam_detection.repository.RecordRepository;
import com.example.scam_detection.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<Record> getRecords(){
        return recordRepository.findAll();
    }

    @Override
    public Record getRecordById(Integer id){
        Record record = recordRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Record with id "+id+" not found"));
        return record;
    }
    
}
