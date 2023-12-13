package com.example.scam_detection.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRecordId implements Serializable {
    private String email;
    private Integer recordId;
}
