package com.garage.demo.repository;

import com.garage.demo.model.PieceTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface uploadRepository extends JpaRepository<PieceTest, Long> {


}