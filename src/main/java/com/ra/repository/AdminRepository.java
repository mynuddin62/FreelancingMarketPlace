package com.ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ra.model.AdminUser;

@Repository
public interface AdminRepository  extends JpaRepository<AdminUser, Integer>{

	AdminUser findByEmailAndPassword(String email, String password);

}
