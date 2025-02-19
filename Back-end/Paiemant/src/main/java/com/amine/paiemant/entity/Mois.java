package com.amine.paiemant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Mois {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMois;
    @Enumerated(EnumType.STRING)
    private MoisEnum mois;

    private float montant;
    private float rest;
    private Date date_de_paiement;

    @ManyToOne
    @JoinColumn(name = "paiement_id")
    private Paiement paiement;

}
