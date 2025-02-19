package com.amine.etudiant.controller;


import com.amine.etudiant.model.Paiement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="Paiement", url = "http://localhost:9090/api/")
public interface PaiementFieng {

    @GetMapping("/Paiement")
    List<Paiement> findAll();

    @GetMapping("/Paiement/{id}")
    Paiement findById(@PathVariable Long id);

    @GetMapping("/Paiement/lastid")
     Long getPaiementLastid();

    @PostMapping("/Paiement")
    void addPaiement(@RequestBody Paiement paiement);

    @DeleteMapping("/Paiement")
    void deletePaiement(@RequestBody Paiement paiement);
}
