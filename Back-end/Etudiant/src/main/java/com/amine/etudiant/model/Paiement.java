package com.amine.etudiant.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Paiement {
    private Long paiementId;
    private Long IdEtudiant;
    private float montant;

    @OneToMany(mappedBy = "paiement", cascade = CascadeType.ALL)
    private List<Mois> mois;
}
