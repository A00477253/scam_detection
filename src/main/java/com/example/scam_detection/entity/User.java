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
public class User {
    @Id
    private Integer userId;

    private String phoneNumber;
    private String email;
    private Integer age;
    private String name;

    @OneToMany(mappedBy = "user")
    private Set<Record> records;

    @OneToMany(mappedBy = "user")
    private Set<Scam> scams;

}
