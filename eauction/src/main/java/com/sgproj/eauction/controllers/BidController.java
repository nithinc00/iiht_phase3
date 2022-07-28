package com.sgproj.eauction.controllers;

import com.sgproj.eauction.entities.Bid;
import com.sgproj.eauction.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class BidController {
    @Autowired
    private BidService bidService;

    @GetMapping("/api/bids")
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }
}
