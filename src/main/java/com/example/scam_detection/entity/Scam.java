package com.example.scam_detection.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="scams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scam {
    @Id
    private Integer scamId;

    private String lostResource;
    private LocalDateTime time;
    
    @ManyToOne
    @JoinColumn(name = "scammer_id")
    private Scammer scammer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
