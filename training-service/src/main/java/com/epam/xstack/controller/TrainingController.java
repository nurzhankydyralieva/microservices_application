package com.epam.xstack.controller;

import com.epam.xstack.model.dto.TrainerDTO;
import com.epam.xstack.service.TrainingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/training")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainerService;

    @GetMapping
    public ResponseEntity<Map<String, Map<String, Integer>>> getMonthlySummary() {
        Map<String, Map<String, Integer>> summary = trainerService.calculateMonthlySummary();
        log.info("Method calculateMonthlySummary() in Training controller is ended");
        return ResponseEntity.ok(summary);

    }

    @PostMapping
    public ResponseEntity<TrainerDTO> createTrainer(@RequestBody TrainerDTO trainer) {
        trainerService.addTrainer(trainer);
        log.info("Trainer is created");
        return new ResponseEntity<>(trainer, HttpStatus.CREATED);
    }
}
