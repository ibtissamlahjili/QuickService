package com.garage.demo.repository;

import com.garage.demo.model.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RDVRepository extends JpaRepository<RDV, Long> {
    // Ajoutez des méthodes personnalisées ici si nécessaire
    Optional<RDV> findByDateAndHeure(String date, String heure);

    void deleteByUserId(int userId);
}
