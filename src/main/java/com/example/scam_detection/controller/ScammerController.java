package com.example.scam_detection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scam_detection.entity.Scammer;
import com.example.scam_detection.service.ScammerService;

@RestController
@RequestMapping("/scammer")
@CrossOrigin(origins = "http://localhost:3000")
public class ScammerController {

    @Autowired
    private ScammerService scammerService;

    @GetMapping("/all")
    public List<Scammer> getScammers(){
        return scammerService.getScammers();
    }
    
}
