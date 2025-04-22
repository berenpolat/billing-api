package com.mobileprovider.dto;

import com.mobileprovider.model.UsageType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UsageDTO {

    private String subscriberNo;
    private String month;
    @Enumerated(EnumType.STRING)
    private UsageType usageType;
    private int amount;
    private int year;

    // --- Getters ---
    public String getSubscriberNo() {
        return subscriberNo;
    }

    public String getMonth() {
        return month;
    }
    public int getYear() {
        return year; // ✅ correct way
    }

    public void setYear(int year) {
        this.year = year;
    }
    public UsageType getUsageType() {
        return usageType;
    }

    public int getAmount() {
        return amount;
    }

    // --- Setters ---
    public void setSubscriberNo(String subscriberNo) {
        this.subscriberNo = subscriberNo;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UsageType getType() {
        return usageType;
    }

}
