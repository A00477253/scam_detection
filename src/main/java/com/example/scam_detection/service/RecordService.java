package com.example.scam_detection.service;


import com.example.scam_detection.entity.*;
import com.example.scam_detection.entity.Record;
import com.example.scam_detection.model.AgeDTO;
import com.example.scam_detection.model.RecordDTO;
import com.example.scam_detection.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecrordRepository recordRepository;

    @Autowired
    private ScamRepository scamRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScamCategoryRepository scamCategoryRepository;

    @Autowired
    private CallRecordRepository callRecordRepository;

    @Autowired
    private EmailRecordRepository emailRecordRepository;



    public Record saveRecord(RecordDTO recordDTO) throws SQLException {
        if(recordDTO.getRecord().getUser()==null){
            throw new SQLException("User Object needed to insert record ");
        }
        if(recordDTO.getRecord().getScammer()==null){
            throw new SQLException("Scammer Object needed to insert record ");
        }
        ScamCategory scamCategory=scamCategoryRepository.findByType(recordDTO.getType());
        recordDTO.getRecord().getScammer().setScamCategory(scamCategory);

        Record returnRecord= recordRepository.save(recordDTO.getRecord());
        Scam scam=Scam.builder().lostResource(recordDTO.getLostResource())
                        .scammer(returnRecord.getScammer())
                                .user(returnRecord.getUser()).time(LocalDateTime.now()).build();
        scamRepository.save(scam);

        System.out.println("The return record is "+returnRecord.getRecordId());
        if(recordDTO.getRecord().getScammer().getEmail()!=null
                && !recordDTO.getRecord().getScammer().getEmail().isEmpty()){
            EmailRecordId emailRecordId= EmailRecordId.builder()
                    .recordId(returnRecord.getRecordId())
                    .email(returnRecord.getScammer().getEmail())
                    .build();
            EmailRecord emailRecord=EmailRecord.builder().id(emailRecordId)
                            .content(recordDTO.getContent())
                            .record(recordDTO.getRecord())
                            .build();
            System.out.println(emailRecord);
            emailRecordRepository.save(emailRecord);

        }
        if (recordDTO.getRecord().getScammer().getPhoneNumber()!=null
                && !recordDTO.getRecord().getScammer().getPhoneNumber().isEmpty()) {
            CallRecordId callRecordId= CallRecordId.builder()
                    .recordId(returnRecord.getRecordId())
                    .phoneNumber(returnRecord.getScammer().getPhoneNumber())
                    .build();
            CallRecord callRecord=CallRecord.builder().record(recordDTO.getRecord())
                            .id(callRecordId)
                                    .duration(recordDTO.getDuration())
                                            .build();
            callRecordRepository.save(callRecord);
        }


        return returnRecord;
    }

    public List<AgeDTO> ageDTOList(){

        return userRepository.findAgeAndRecordCount();
    }
}
