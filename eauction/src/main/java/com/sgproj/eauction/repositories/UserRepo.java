package com.sgproj.eauction.repositories;

import com.sgproj.eauction.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
