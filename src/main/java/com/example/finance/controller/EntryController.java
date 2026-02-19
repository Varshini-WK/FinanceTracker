package com.example.finance.controller;

import com.example.finance.model.FinanceEntry;
import com.example.finance.service.EntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entries")
public class EntryController {

    private final EntryService service;

    public EntryController(EntryService service) {
        this.service = service;
    }

    @PostMapping
    public FinanceEntry create(@RequestBody FinanceEntry entry) {
        return service.create(entry);
    }

    @GetMapping
    public List<FinanceEntry> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FinanceEntry getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public FinanceEntry update(@PathVariable Long id, @RequestBody FinanceEntry entry) {
        return service.update(id, entry);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
