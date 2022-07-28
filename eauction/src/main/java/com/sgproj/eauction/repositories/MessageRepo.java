package com.sgproj.eauction.repositories;

import com.sgproj.eauction.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message,Long> {
}
