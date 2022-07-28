package com.sgproj.eauction.services;

import com.sgproj.eauction.entities.AuctionItem;
import com.sgproj.eauction.repositories.AuctionRepo;
import com.sgproj.eauction.repositories.BidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {
    @Autowired
    private AuctionRepo auctionRepo;

    @Autowired
    private BidRepo bidRepo;

    private AuctionItem auctionItem;
    public List<AuctionItem> getAllItems() {
        return auctionRepo.findAll();
    }

    public Optional<AuctionItem> getOneItem(Long id) {
        return auctionRepo.findById(id);
    }
}
