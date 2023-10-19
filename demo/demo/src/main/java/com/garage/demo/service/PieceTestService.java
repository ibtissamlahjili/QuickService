package com.garage.demo.service;

import com.garage.demo.model.PieceTest;
import com.garage.demo.repository.uploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PieceTestService {
    @Autowired
    private uploadRepository pieceRepository;
    public PieceTest getPieceById(long id) {
        return pieceRepository.findById(id).get();
    }
    public void deletePieceById(long id) {
        pieceRepository.deleteById(id);
    }

}
