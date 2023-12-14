package com.example.scam_detection.controller;

import com.example.scam_detection.entity.Scam;
import com.example.scam_detection.model.*;
import com.example.scam_detection.service.RecordService;
import com.example.scam_detection.service.ScamService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/scam")
@CrossOrigin(origins = "http://localhost:3000")
public class ScamController {

    @Autowired
    private RecordService recordService;

    @Autowired
    private ScamService scamService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<?> saveScamRecord(@RequestBody RecordDTO record){
        try{
            return ResponseEntity.ok(recordService.saveRecord(record));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @GetMapping("/age")
    public List<AgeDTO> getAgeList(){
        return recordService.ageDTOList();
    }


    @GetMapping("/all")
    public List<Scam> getScams(){

        List<Scam> scamList= scamService.getScams();
       // return scamList.stream().map(Scam::toDto).collect(Collectors.toList());
        return scamList;

    }

    @PostMapping("/scamStats")
    public TypeDto getScamCounts(@RequestBody AgeGroupDTO ageGroupDTO){
        System.out.println(ageGroupDTO);
        TypeDto typeDto=recordService.getScamStats(ageGroupDTO);
        System.out.println(typeDto);
        return typeDto;
    }
}
