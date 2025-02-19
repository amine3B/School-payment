package com.amine.etudiant.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class Classe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasse;
    @Column(unique = true)
    private String nom_Classe;
    private boolean active;
}
