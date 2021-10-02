package com.ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ra.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByEmailAndPassword(String email, String password);
    
}
