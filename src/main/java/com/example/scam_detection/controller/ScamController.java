package com.example.scam_detection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scam_detection.entity.Scam;
import com.example.scam_detection.service.ScamService;

@RestController
@RequestMapping("/scam")
public class ScamController {

    @Autowired
    private ScamService scamService;

    @GetMapping("/all")
    public List<Scam> getScams(){
        return scamService.getScams();
    }
}
