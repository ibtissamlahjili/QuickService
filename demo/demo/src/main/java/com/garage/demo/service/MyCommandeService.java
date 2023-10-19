package com.garage.demo.service;

import com.garage.demo.model.MyCommande;
import com.garage.demo.repository.MyCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCommandeService {
    @Autowired
    private MyCommandeRepository mybook;

    public void saveMyBooks(MyCommande piece) {
        mybook.save(piece);
    }

    public List<MyCommande> getAllMyBooks(){
        return mybook.findAll();
    }

    public void deleteById(long id) {
        mybook.deleteById(id);
    }
}