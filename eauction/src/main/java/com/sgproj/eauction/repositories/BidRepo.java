package com.sgproj.eauction.repositories;

import com.sgproj.eauction.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepo extends JpaRepository<Bid,Long> {
}
