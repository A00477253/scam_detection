package com.example.scam_detection.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScamDetailsDTO {
    private Long scamId;
    private Long scammerId;
    private Long userId;
    private String lostResource;
    private LocalDateTime time;
}
