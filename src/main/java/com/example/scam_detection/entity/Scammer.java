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
@NoArgsConstructor
@AllArgsConstructor
public class Scammer {
    @Id
    private Integer scammerId;

    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "scammer")
    private Set<Scam> scams;

    @OneToMany(mappedBy = "scammer")
    private Set<Record> records;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ScamCategory scamCategory;

}
