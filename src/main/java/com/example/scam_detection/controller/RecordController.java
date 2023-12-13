package com.example.scam_detection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scam_detection.entity.Record;
import com.example.scam_detection.service.RecordService;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("all")
    public List<Record> getRecords(){
        return recordService.getRecords();
    }

    @GetMapping("get")
    public Record getRecordById(Integer id){
        return recordService.getRecordById(id);
    }
    
}
