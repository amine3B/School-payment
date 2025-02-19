package com.amine.paiemant.Controller;

import com.amine.paiemant.Repository.PaiemantRepository;
import com.amine.paiemant.entity.Paiement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class PaiementController {

    private final PaiemantRepository paiemantRepository;

    @Autowired
    public PaiementController(PaiemantRepository paiementRepository) {
        this.paiemantRepository = paiementRepository;
    }

    @GetMapping("/Paiement")
    public List<Paiement> getPaiements() {
        return paiemantRepository.findAll();
    }

    @GetMapping("/Paiement/{id}")
    public Optional<Paiement> getPaiementById(@PathVariable Long id) {
        return paiemantRepository.findById(id);
    }
    @GetMapping("/Paiement/lastid")
    public Long getPaiementLastid() {
        return paiemantRepository.findLastPaiementId();
    }

    @PostMapping("/Paiement")
    public void addPaiement(@RequestBody Paiement paiement) {
        paiemantRepository.save(paiement);
    }

    @DeleteMapping("/Paiement/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        if (!paiemantRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        paiemantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
