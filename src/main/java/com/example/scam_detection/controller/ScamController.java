package com.example.scam_detection.controller;

import com.example.scam_detection.entity.Record;
import com.example.scam_detection.model.AgeDTO;
import com.example.scam_detection.model.RecordDTO;
import com.example.scam_detection.service.RecordService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scam")
public class ScamController {

    @Autowired
    private RecordService recordService;
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

}
