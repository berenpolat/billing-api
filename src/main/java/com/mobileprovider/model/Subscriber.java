package com.mobileprovider.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subscriberNo;

    // --- Getters ---
    public Long getId() {
        return id;
    }

    public String getSubscriberNo() {
        return subscriberNo;
    }

    // --- Setters ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setSubscriberNo(String subscriberNo) {
        this.subscriberNo = subscriberNo;
    }
}
