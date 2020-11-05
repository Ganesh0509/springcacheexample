package com.example.springbootcache.entity;

public class Customer {
    public Customer(Long customer_id, Offer offer) {
        this.customer_id = customer_id;
        this.offer = offer;
    }

    private Long customer_id ;
    private Offer offer ;
    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
