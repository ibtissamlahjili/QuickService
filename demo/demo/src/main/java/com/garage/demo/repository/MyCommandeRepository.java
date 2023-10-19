package com.garage.demo.repository;

import com.garage.demo.model.MyCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCommandeRepository extends JpaRepository<MyCommande,Long> {
}