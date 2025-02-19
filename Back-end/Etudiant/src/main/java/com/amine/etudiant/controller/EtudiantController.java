package com.amine.etudiant.controller;


import com.amine.etudiant.entity.Etudiant;
import com.amine.etudiant.model.Paiement;
import com.amine.etudiant.repository.EtudiantRepository;
import com.amine.etudiant.controller.PaiementFieng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class EtudiantController {

    private final EtudiantRepository etudiantRepository;
    private final PaiementFieng paiementFeign;

    @Autowired
    public EtudiantController(EtudiantRepository etudiantRepository, PaiementFieng paiementFeign) {
        this.etudiantRepository = etudiantRepository;
        this.paiementFeign = paiementFeign;
    }

    @GetMapping("/Etudiant")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        //for (Etudiant e : etudiants) {
        //    Paiement p = paiementFeign.findById(e.getIdPaiement());
        //    e.setPaiement(p);
        //    }
        return etudiants;
    }

    @GetMapping("/Etudiant/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        return etudiant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/Etudiant/count")
    public Long getEtudiantCount() {
        return   etudiantRepository.count();
    }

    @PostMapping("/Etudiant")
    public ResponseEntity<?> addEtudiant(@RequestBody Etudiant etudiant) {
        if (etudiant.getIdPaiement() != null) {
            Paiement paiement = paiementFeign.findById(etudiant.getIdPaiement());
            if (paiement == null) {
                return ResponseEntity.badRequest().body("Le paiement avec ID " + etudiant.getIdPaiement() + " n'existe pas.");
            }
        }
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        return ResponseEntity.ok(savedEtudiant);
    }

    @DeleteMapping("/Etudiant/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        if (!etudiantRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        etudiantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
