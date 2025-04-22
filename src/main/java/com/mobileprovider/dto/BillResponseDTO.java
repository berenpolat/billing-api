package com.mobileprovider.dto;

public class BillResponseDTO {
    private double total;
    private boolean paid;

    public BillResponseDTO() {}

    public BillResponseDTO(double total, boolean paid) {
        this.total = total;
        this.paid = paid;
    }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
}
