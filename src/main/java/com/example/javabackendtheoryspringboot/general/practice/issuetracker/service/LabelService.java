package com.example.javabackendtheoryspringboot.general.practice.issuetracker.service;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Label;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.CreateLabelRequest;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.LabelResponse;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.exception.LabelNotFoundException;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.mapper.LabelMapper;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.repository.LabelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelService {

    private final LabelRepository labelRepository;
    private final LabelMapper labelMapper;


    public LabelService(LabelRepository labelRepository,
                        LabelMapper labelMapper) {
        this.labelRepository = labelRepository;
        this.labelMapper = labelMapper;
    }

    @Transactional
    public LabelResponse createLabel(CreateLabelRequest request) {
        Label label = new Label(
                request.getName(),
                request.getColor()
        );

        Label savedLabel = labelRepository.save(label);

        return labelMapper.toResponse(savedLabel);
    }

    @Transactional(readOnly = true)
    public List<LabelResponse> getAllLabels() {
        List<Label> labels = labelRepository.findAll();

        List<LabelResponse> responses = new ArrayList<>();

        for (Label label : labels) {
            responses.add(labelMapper.toResponse(label));
        }

        return responses;
    }

    @Transactional(readOnly = true)
    public LabelResponse getLabelById(Long id) {
        Label label = getLabelEntityById(id);

        return labelMapper.toResponse(label);
    }

    @Transactional(readOnly = true)
    public Label getLabelEntityById(Long id) {
        return labelRepository.findById(id)
                .orElseThrow(() -> new LabelNotFoundException(id));
    }
}
