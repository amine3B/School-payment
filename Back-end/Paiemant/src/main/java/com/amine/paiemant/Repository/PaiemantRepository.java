package com.amine.paiemant.Repository;

import com.amine.paiemant.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaiemantRepository extends JpaRepository<Paiement , Long> {

    @Query("SELECT MAX(p.paiementId) FROM Paiement p")
    Long findLastPaiementId();
}
