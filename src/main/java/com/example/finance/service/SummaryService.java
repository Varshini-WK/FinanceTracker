package com.example.finance.service;

import com.example.finance.model.EntryType;
import com.example.finance.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class SummaryService {

    private final EntryRepository repository;

    public SummaryService(EntryRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> getSummary() {

        BigDecimal income = repository.findAll().stream()
                .filter(e -> e.getType() == EntryType.INCOME)
                .map(e -> e.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expense = repository.findAll().stream()
                .filter(e -> e.getType() == EntryType.EXPENSE)
                .map(e -> e.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return Map.of(
                "totalIncome", income,
                "totalExpense", expense,
                "balance", income.subtract(expense)
        );
    }
}
