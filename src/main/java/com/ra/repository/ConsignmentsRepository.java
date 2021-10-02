package com.ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ra.model.ConsignmentsEntity;

@Repository
public interface ConsignmentsRepository extends JpaRepository<ConsignmentsEntity, Integer> {

	ConsignmentsEntity getBySellerid(int id);

	ConsignmentsEntity getByBuyerid(int id);

}
