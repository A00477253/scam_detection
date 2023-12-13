package com.example.scam_detection.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScamCategory {
    @Id
    private Integer categoryId;

    private String description;
    private String type;

    @OneToMany(mappedBy = "scamCategory")
    private Set<Scammer> scammers;
}
