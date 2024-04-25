package com.epam.xstack.service;

import com.epam.xstack.model.dto.TrainerDTO;

import java.util.Map;

public interface TrainingService {
    TrainerDTO addTrainer(TrainerDTO trainerDTO);

    Map<String, Map<String, Integer>> calculateMonthlySummary();
}
