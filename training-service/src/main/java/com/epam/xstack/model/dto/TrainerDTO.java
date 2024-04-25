package com.epam.xstack.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String status;
    private List<Integer> years;
    private List<String> months;
    private Integer duration;
}
