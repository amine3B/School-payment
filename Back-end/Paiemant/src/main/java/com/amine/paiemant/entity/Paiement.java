package com.amine.paiemant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder


public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paiementId;
    @Column(nullable = false)
    private float montant;

    @OneToMany(mappedBy = "paiement", cascade = CascadeType.ALL)
    private List<Mois> mois;

}
