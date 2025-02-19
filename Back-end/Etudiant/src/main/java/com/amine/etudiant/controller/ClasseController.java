package com.amine.etudiant.controller;

import com.amine.etudiant.entity.Classe;
import com.amine.etudiant.repository.ClasseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ClasseController {

    private final ClasseRepository classeRepository;


    public ClasseController(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @GetMapping("/Classe")
    public List<Classe> getClasse() {
        return classeRepository.findAll();
    }

    @GetMapping("Classe/count")
    public Long getClasseCount() {
        return classeRepository.count();
    }

    @PostMapping("/Classe")
    public void addClasse(@RequestBody Classe classe) {
        classeRepository.save(classe);

    }

    @DeleteMapping("/Classe")
    public void deleteEtudiant(@RequestBody Classe classe) {
        classeRepository.delete(classe);
    }
}
