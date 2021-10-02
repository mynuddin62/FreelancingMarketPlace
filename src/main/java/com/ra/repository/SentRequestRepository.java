package com.ra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ra.model.SentRequestEntity;

@Repository
public interface SentRequestRepository extends JpaRepository<SentRequestEntity, Integer> {

	List<SentRequestEntity> findByRequesttoid(int id);

}
