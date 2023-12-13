package com.example.scam_detection.service;

import java.util.List;

import com.example.scam_detection.entity.Record;

public interface RecordService {

    List<Record> getRecords();

    Record getRecordById(Integer id);
}
