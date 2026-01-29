package com.example.finance.repository;

import com.example.finance.model.FinanceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<FinanceEntry, Long> {
}
