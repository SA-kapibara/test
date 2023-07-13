package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StationEntity;

@Repository
public interface StationRepository extends JpaRepository<StationEntity, Integer> {

}