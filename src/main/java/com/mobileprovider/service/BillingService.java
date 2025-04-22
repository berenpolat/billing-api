package com.mobileprovider.service;

import com.mobileprovider.dto.BillRequestDTO;
import com.mobileprovider.dto.BillResponseDTO;
import com.mobileprovider.dto.UsageDTO;
import com.mobileprovider.model.Usage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BillingService {
    String addUsage(UsageDTO dto);
    String calculateBill(BillRequestDTO dto);
    BillResponseDTO queryBill(String subscriberNo, String month, int year);
    Page<Usage> queryBillDetailed(String subscriberNo, String month, int year, Pageable pageable);
    String payBill(String subscriberNo, String month, int year, double amount);
}
