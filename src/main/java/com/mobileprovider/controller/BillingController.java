package com.mobileprovider.controller;

import com.mobileprovider.dto.BillRequestDTO;
import com.mobileprovider.dto.BillResponseDTO;
import com.mobileprovider.dto.UsageDTO;
import com.mobileprovider.model.Usage;
import com.mobileprovider.service.BillingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Billing Controller", description = "Handles billing operations")
@RequestMapping("/api/v1")  // ✅ versioned API path
public class BillingController {

    @Autowired
    private BillingService billingService;

    @Operation(summary = "Add usage record", description = "Adds a new usage record for a subscriber")
    @PostMapping("/usage")
    public String addUsage(@RequestBody UsageDTO dto) {
        return billingService.addUsage(dto);
    }

    @Operation(summary = "Calculate bill", description = "Calculates the bill for a given subscriber and month")
    @PostMapping("/bill/calculate")
    public String calculateBill(@RequestBody BillRequestDTO dto) {
        return billingService.calculateBill(dto);
    }

    @GetMapping("/bill/query")
    public BillResponseDTO queryBill(
            @RequestParam String subscriberNo,
            @RequestParam String month,
            @RequestParam int year
    ) {
        return billingService.queryBill(subscriberNo, month, year);
    }

    @GetMapping("/bill/detailed")
    public Page<Usage> queryBillDetailed(
            @RequestParam String subscriberNo,
            @RequestParam String month,
            @RequestParam int year,
            Pageable pageable
    ) {
        return billingService.queryBillDetailed(subscriberNo, month, year, pageable);
    }

    @PostMapping("/bill/pay")
    public String payBill(
            @RequestParam String subscriberNo,
            @RequestParam String month,
            @RequestParam int year,
            @RequestParam double amount
    ) {
        return billingService.payBill(subscriberNo, month, year, amount);
    }
}
