package com.mobileprovider.model;

import jakarta.persistence.*;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subscriberNo;
    private String month;
    private int year;
    private double phoneCharge;
    private double internetCharge;
    private double total;
    private boolean paid;

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

    public double getPhoneCharge() {
        return phoneCharge;
    }

    public double getInternetCharge() {
        return internetCharge;
    }

    public double getTotal() {
        return total;
    }

    public boolean isPaid() {
        return paid;
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

    public void setPhoneCharge(double phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    public void setInternetCharge(double internetCharge) {
        this.internetCharge = internetCharge;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
