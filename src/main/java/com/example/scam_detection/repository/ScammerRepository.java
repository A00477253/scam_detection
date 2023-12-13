package com.example.scam_detection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scam_detection.entity.Scammer;

public interface ScammerRepository extends JpaRepository<Scammer, Integer> {
}
