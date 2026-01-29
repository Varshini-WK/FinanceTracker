package com.example.finance.service;

import com.example.finance.exception.ResourceNotFoundException;
import com.example.finance.model.FinanceEntry;
import com.example.finance.repository.EntryRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntryService {

    private final EntryRepository repository;

    public EntryService(EntryRepository repository) {
        this.repository = repository;
    }

    public FinanceEntry create(FinanceEntry entry) {
        return repository.save(entry);
    }

    public List<FinanceEntry> getAll() {
        return repository.findAll();
    }

    public FinanceEntry getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entry not found"));
    }

    public FinanceEntry update(Long id, FinanceEntry updated) {
        FinanceEntry entry = getById(id);
        entry.setAmount(updated.getAmount());
        entry.setCategory(updated.getCategory());
        entry.setType(updated.getType());
        entry.setEntryDate(updated.getEntryDate());
        entry.setDescription(updated.getDescription());
        return repository.save(entry);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
