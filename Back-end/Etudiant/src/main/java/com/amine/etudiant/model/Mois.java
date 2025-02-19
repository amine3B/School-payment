package com.amine.etudiant.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Mois {
    private Long IdMois;
    @Enumerated(EnumType.STRING)
    private MoisEnum mois;

    private float montant;
    private float rest;
    private Date date_de_paiement;
    @ManyToOne
    @JoinColumn(name = "paiement_id")
    private Paiement paiement;

    public enum MoisEnum {
        SEPTEMBRE,
        OCTOBRE,
        NOVEMBRE,
        DECEMBRE,
        JANVIER,
        FEVRIER,
        MARS,
        AVRIL,
        MAI,
        JUIN
    }
}
