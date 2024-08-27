package com.dailycodework.universalpetcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feedback;
    private int stars;
    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private User veterinarian;
    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private User patient;

    public void removeRelationShip(){
        Optional.ofNullable(veterinarian)
                .ifPresent(vet -> vet.getReviews().remove(this));
        Optional.ofNullable(patient)
                .ifPresent(patient -> patient.getReviews().remove(this));
    }
}
