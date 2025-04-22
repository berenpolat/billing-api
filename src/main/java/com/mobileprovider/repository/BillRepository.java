package com.mobileprovider.repository;

import com.mobileprovider.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    Optional<Bill> findBySubscriberNoAndMonthAndYear(String subscriberNo, String month, int year);
}
