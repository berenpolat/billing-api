package com.mobileprovider.repository;

import com.mobileprovider.model.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsageRepository extends JpaRepository<Usage, Long> {
    List<Usage> findBySubscriberNoAndMonthAndYear(String subscriberNo, String month, int year);
}
