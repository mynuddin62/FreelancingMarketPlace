package com.ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ra.model.WorkternSystemEntity;

@Repository
public interface WorkternSystemRepository extends JpaRepository<WorkternSystemEntity, Integer> {

}
