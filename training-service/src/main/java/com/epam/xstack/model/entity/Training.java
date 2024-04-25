package com.epam.xstack.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "training")
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String month;
    private Integer year;
    private Integer duration;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Trainer trainer;
}
