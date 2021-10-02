package com.ra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ra.model.OfferPostEntity;

@Repository
public interface OfferPostRepository extends JpaRepository<OfferPostEntity, Long> {

	List<OfferPostEntity> findByPostedbyid(int id);



}
