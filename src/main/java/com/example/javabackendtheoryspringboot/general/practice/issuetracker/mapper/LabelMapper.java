package com.example.javabackendtheoryspringboot.general.practice.issuetracker.mapper;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Label;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.LabelResponse;
import org.springframework.stereotype.Component;

@Component
public class LabelMapper {

    public LabelResponse toResponse(Label label) {
        return new LabelResponse(
                label.getId(),
                label.getName(),
                label.getColor(),
                label.getCreatedAt()
        );
    }
}
