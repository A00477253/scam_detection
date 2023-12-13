package com.example.scam_detection.entity;

import lombok.*;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "Call_record")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CallRecord {

    @EmbeddedId
    private CallRecordId id;

    @Column(name = "duration")
    private Timestamp duration;

    @ManyToOne
    @JoinColumn(name = "recordId", insertable = false, updatable = false)
    private Record record;

}



