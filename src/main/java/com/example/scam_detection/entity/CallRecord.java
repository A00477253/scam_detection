package com.example.scam_detection.entity;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CallRecord {
    @EmbeddedId
    private CallRecordId id;

    private LocalDateTime duration;

    @ManyToOne
    @MapsId("recordId")
    @JoinColumn(name = "record_id")
    private Record record;
}
