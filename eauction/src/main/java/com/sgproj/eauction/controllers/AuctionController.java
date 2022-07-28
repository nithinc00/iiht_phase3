package com.sgproj.eauction.controllers;

import com.sgproj.eauction.entities.AuctionItem;
import com.sgproj.eauction.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping
    public List<AuctionItem> getAllItems() {
        return auctionService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<AuctionItem> getOneItem(@PathVariable Long id) {
        return auctionService.getOneItem(id);
    }
}
