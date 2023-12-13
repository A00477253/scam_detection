package com.example.scam_detection.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    private Integer recordId;

    private String reported;

    @OneToMany(mappedBy = "record")
    private Set<EmailRecord> emailRecords;

    @OneToMany(mappedBy = "record")
    private Set<CallRecord> callRecords;

    @ManyToOne
    @JoinColumn(name = "scammer_id")
    private Scammer scammer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
