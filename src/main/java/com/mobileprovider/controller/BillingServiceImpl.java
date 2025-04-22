package com.mobileprovider.controller;

import com.mobileprovider.dto.BillRequestDTO;
import com.mobileprovider.dto.BillResponseDTO;
import com.mobileprovider.dto.UsageDTO;
import com.mobileprovider.model.Bill;
import com.mobileprovider.model.Usage;
import com.mobileprovider.model.UsageType;
import com.mobileprovider.repository.BillRepository;
import com.mobileprovider.repository.UsageRepository;
import com.mobileprovider.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private UsageRepository usageRepository;

    @Autowired
    private BillRepository billRepository;

    @Override
    public String addUsage(UsageDTO dto) {
        Usage usage = new Usage();
        usage.setSubscriberNo(dto.getSubscriberNo());
        usage.setUsageType(dto.getType());
        usage.setAmount(dto.getAmount());
        usage.setMonth(dto.getMonth());
        usage.setYear(dto.getYear());

        usageRepository.save(usage);
        return "Usage saved successfully.";
    }

    @Override
    public String calculateBill(BillRequestDTO dto) {
        List<Usage> usages = usageRepository.findBySubscriberNoAndMonthAndYear(
                dto.getSubscriberNo(), dto.getMonth(), dto.getYear()
        );

        int phoneMinutes = usages.stream()
                .filter(u -> u.getUsageType() == UsageType.PHONE)
                .mapToInt(Usage::getAmount)
                .sum();

        int internetMB = usages.stream()
                .filter(u -> u.getUsageType() == UsageType.INTERNET)
                .mapToInt(Usage::getAmount)
                .sum();

        double phoneCharge = (phoneMinutes > 1000) ? ((phoneMinutes - 1000) / 1000) * 10.0 : 0.0;
        double internetCharge = 50.0;

        if (internetMB > 20480) {
            internetCharge += ((internetMB - 20480) / 10240) * 10.0;
        }

        double total = phoneCharge + internetCharge;

        // Save or update bill
        Optional<Bill> existing = billRepository.findBySubscriberNoAndMonthAndYear(
                dto.getSubscriberNo(), dto.getMonth(), dto.getYear()
        );

        Bill bill = existing.orElse(new Bill());
        bill.setSubscriberNo(dto.getSubscriberNo());
        bill.setMonth(dto.getMonth());
        bill.setYear(dto.getYear());
        bill.setPhoneCharge(phoneCharge);
        bill.setInternetCharge(internetCharge);
        bill.setTotal(total);

        billRepository.save(bill);

        return "Bill calculated successfully.";
    }

    @Override
    public BillResponseDTO queryBill(String subscriberNo, String month, int year) {
        Bill bill = billRepository.findBySubscriberNoAndMonthAndYear(subscriberNo, month, year)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        return new BillResponseDTO(bill.getTotal(), bill.isPaid());
    }

    @Override
    public Page<Usage> queryBillDetailed(String subscriberNo, String month, int year, Pageable pageable) {
        List<Usage> all = usageRepository.findBySubscriberNoAndMonthAndYear(subscriberNo, month, year);
        return new PageImpl<>(all, pageable, all.size());
    }

    @Override
    public String payBill(String subscriberNo, String month, int year, double amount) {
        Bill bill = billRepository.findBySubscriberNoAndMonthAndYear(subscriberNo, month, year)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        double remaining = bill.getTotal();
        if (amount >= remaining) {
            bill.setPaid(true);
            bill.setTotal(0);
        } else {
            bill.setTotal(remaining - amount); // partial
        }

        billRepository.save(bill);
        return "Payment processed.";
    }
}
