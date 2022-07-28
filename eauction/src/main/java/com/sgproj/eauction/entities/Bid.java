package com.sgproj.eauction.entities;

import javax.persistence.*;

@Entity
@Table(name="bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = true)
    private Integer auction_id;
    private Integer bid;
    @Column(nullable = true)
    private Integer bidder_id;
    private Long created_at;
    @OneToOne
    @JoinColumn(name = "auction_id", updatable=false, insertable = false)
    private AuctionItem auction_item;

    @OneToOne
    @JoinColumn(name = "bidder_id", updatable=false, insertable = false)
    private User bidder;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getAuction_id() {
        return auction_id;
    }
    public void setAuction_id(Integer auction_id) {
        this.auction_id = auction_id;
    }
    public Integer getBid() {
        return bid;
    }
    public void setBid(Integer bid) {
        this.bid = bid;
    }
    public Integer getBidder_id() {
        return bidder_id;
    }
    public void setBidder_id(Integer bidder_id) {
        this.bidder_id = bidder_id;
    }
    public Long getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }
    public AuctionItem getAuction_item() {
        return auction_item;
    }
    public void setAuction_item(AuctionItem auction_item) {
        this.auction_item = auction_item;
    }
}
