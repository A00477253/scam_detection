package com.example.scam_detection.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scam_detection.service.TableService;

@RestController
@RequestMapping("/table")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/all")
    public List<String> getTables(){


        return tableService.getAllTableNames();
    }
    
}
