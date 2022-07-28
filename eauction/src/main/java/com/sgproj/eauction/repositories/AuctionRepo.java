package com.sgproj.eauction.repositories;

import com.sgproj.eauction.entities.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepo extends JpaRepository<AuctionItem,Long> {
}
