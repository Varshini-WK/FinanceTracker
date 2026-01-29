package com.example.finance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "finance_entries")
@Getter
@Setter
public class FinanceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private String category;

    @Enumerated(EnumType.STRING)
    private EntryType type;

    private LocalDate entryDate;

    private String description;
}
