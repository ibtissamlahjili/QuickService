package com.garage.demo.service;

import com.garage.demo.model.Piece;
import com.garage.demo.repository.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceService {


    @Autowired
    private  PieceRepository pieceRepository;

    @Autowired
    public PieceService(PieceRepository pieceRepository) {
        this.pieceRepository = pieceRepository;
    }


    public List<Piece> getAllPieces() {
        return pieceRepository.findAll();
    }

    public Piece savePiece(Piece piece) {
        return pieceRepository.save(piece);
    }
    public Piece getPieceById(long id) {
        return pieceRepository.findById(id).get();
    }
    public void deletePieceById(long id) {
        pieceRepository.deleteById(id);
    }


}
