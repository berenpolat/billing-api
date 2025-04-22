package com.mobileprovider.dto;

public class BillRequestDTO {

    private String subscriberNo;
    private String month;
    private int year;

    // --- Getters ---
    public String getSubscriberNo() {
        return subscriberNo;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // --- Setters ---
    public void setSubscriberNo(String subscriberNo) {
        this.subscriberNo = subscriberNo;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
