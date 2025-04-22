package com.mobileprovider.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usages")
public class Usage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subscriberNo;
    private String month;
    private int year;

    @Enumerated(EnumType.STRING)
    private UsageType usageType;

    private int amount;

    // --- Getters ---
    public Long getId() {
        return id;
    }

    public String getSubscriberNo() {
        return subscriberNo;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public UsageType getUsageType() {
        return usageType;
    }

    public int getAmount() {
        return amount;
    }

    // --- Setters ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setSubscriberNo(String subscriberNo) {
        this.subscriberNo = subscriberNo;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setType(UsageType type) {
        this.usageType=type;
    }
}
