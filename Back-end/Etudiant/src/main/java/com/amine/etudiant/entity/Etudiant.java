package com.amine.etudiant.entity;

import com.amine.etudiant.model.Paiement;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nom_etudiant;
    private String contact_parent;
    private Long idPaiement;
    @Transient
    private Paiement paiement;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_naissance;
    private Date date_creation;
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "classe_id_classe")
    private Classe classe;
}
