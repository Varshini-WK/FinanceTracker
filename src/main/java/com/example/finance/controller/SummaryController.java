package com.example.finance.controller;

import com.example.finance.service.SummaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SummaryController {

    private final SummaryService service;

    public SummaryController(SummaryService service) {
        this.service = service;
    }

    @GetMapping("/api/v1/summary")
    public Map<String, Object> summary() {
        return service.getSummary();
    }
}
