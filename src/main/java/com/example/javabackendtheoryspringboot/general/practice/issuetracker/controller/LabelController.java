package com.example.javabackendtheoryspringboot.general.practice.issuetracker.controller;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.CreateLabelRequest;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.LabelResponse;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.service.LabelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practice/labels")
public class LabelController {
    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @PostMapping
    public ResponseEntity<LabelResponse> createLabel(@Valid @RequestBody CreateLabelRequest request) {
        LabelResponse response = labelService.createLabel(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping
    public ResponseEntity<List<LabelResponse>> getAllLabels() {
        List<LabelResponse> responses = labelService.getAllLabels();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabelResponse> getLabelById(@PathVariable Long id) {
        LabelResponse response = labelService.getLabelById(id);

        return ResponseEntity.ok(response);
    }
}
