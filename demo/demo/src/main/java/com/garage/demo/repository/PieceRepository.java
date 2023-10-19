package com.garage.demo.repository;

import com.garage.demo.model.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends JpaRepository<Piece, Long> {

    Piece save(Piece piece);
}
