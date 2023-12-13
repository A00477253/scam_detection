package com.example.scam_detection.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRecord {
    @EmbeddedId
    private EmailRecordId id;

    private String content;

    @ManyToOne
    @MapsId("recordId")
    @JoinColumn(name = "record_id")
    private Record record;
}
