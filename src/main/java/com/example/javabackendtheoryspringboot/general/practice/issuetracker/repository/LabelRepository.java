package com.example.javabackendtheoryspringboot.general.practice.issuetracker.repository;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {
}