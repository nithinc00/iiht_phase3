package com.sgproj.eauction.entities;

import javax.persistence.*;

@Entity
@Table(name = "auction_item")
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String item_name;
    private String description;
    @Column(nullable = true)
    private Integer owner_id;
    private String item_image;
    private Integer initial_price;
    private Long start_date;
    private Long stop_date;
    @OneToOne
    @JoinColumn(name = "owner_id", updatable=false, insertable = false)
    private User owner;
    public Integer getId() {
        // TODO Auto-generated method stub
        return owner_id;
    }
    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getOwner_id() {
        return owner_id;
    }
    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }
    public String getItem_image() {
        return item_image;
    }
    public void setItem_image(String item_image) {
        this.item_image = item_image;
    }
    public Integer getInitial_price() {
        return initial_price;
    }
    public void setInitial_price(Integer initial_price) {
        this.initial_price = initial_price;
    }
    public Long getStart_date() {
        return start_date;
    }
    public void setStart_date(Long start_date) {
        this.start_date = start_date;
    }
    public Long getStop_date() {
        return stop_date;
    }
    public void setStop_date(Long stop_date) {
        this.stop_date = stop_date;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
