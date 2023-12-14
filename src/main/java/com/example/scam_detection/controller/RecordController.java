package com.example.scam_detection.controller;

import java.util.List;
import java.util.Map;

import com.example.scam_detection.model.AgeGroupDTO;
import com.example.scam_detection.model.TypeDto;
import com.example.scam_detection.service.impl.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.scam_detection.entity.Record;
import com.example.scam_detection.service.RecordService;

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = "http://localhost:3000")
public class RecordController {

    @Autowired
    private RecordServiceImpl recordService;

    @Autowired
    private RecordService recordServiceImpl;

    @GetMapping("all")
    public List<Record> getRecords(){
        List<Record> recordList= recordService.getRecords();
        System.out.println(recordList);
        return recordList;
    }

    @GetMapping("get/{id}")
    public Record getRecordById(@PathVariable Integer id){

        return recordService.getRecordById(id);
    }

    @PostMapping("/scamStats")
    public TypeDto getScamCounts(@RequestBody AgeGroupDTO ageGroupDTO){
        System.out.println(ageGroupDTO);
        TypeDto typeDto=recordServiceImpl.getScamStats(ageGroupDTO);
        System.out.println(typeDto);
        return typeDto;
    }
    
}
