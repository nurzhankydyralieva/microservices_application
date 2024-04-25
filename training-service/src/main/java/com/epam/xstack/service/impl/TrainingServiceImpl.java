package com.epam.xstack.service.impl;

import com.epam.xstack.model.dto.TrainerDTO;
import com.epam.xstack.service.TrainingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {
    private Map<String, TrainerDTO> trainers = new HashMap<>();

    @Override
    public Map<String, Map<String, Integer>> calculateMonthlySummary() {
        Map<String, Map<String, Integer>> summary = new HashMap<>();
        for (TrainerDTO trainerRequestDTO : trainers.values()) {
            Map<String, Integer> monthlySummary = new HashMap<>();
            for (int i = 0; i < trainerRequestDTO.getYears().size(); i++) {
                int year = trainerRequestDTO.getYears().get(i);
                String month = trainerRequestDTO.getMonths().get(i);
                String key = year + "-" + month;
                monthlySummary.put(key, monthlySummary.getOrDefault(key, 0) + 1);
            }
            summary.put(trainerRequestDTO.getUserName(), monthlySummary);
        }
        log.info("Method calculateMonthlySummary() is ended");
        return summary;
    }

    @Override
    public TrainerDTO addTrainer(TrainerDTO trainerDTO) {
        trainers.put(trainerDTO.getUserName(), trainerDTO);
        log.info("Trainer {} is added", trainerDTO.getUserName());
        return TrainerDTO.builder().build();
    }
}
