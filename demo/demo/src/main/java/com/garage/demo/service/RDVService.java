package com.garage.demo.service;

import com.garage.demo.model.RDV;
import com.garage.demo.repository.RDVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RDVService {
    private RDVRepository rdvRepository;

    @Autowired
    public RDVService(RDVRepository rdvRepository) {
        this.rdvRepository = rdvRepository;
    }

   /* public void saveRDV(RDV rdv) {
        rdvRepository.save(rdv);
    }*/

    public List<RDV> getAllRDV(){
        return rdvRepository.findAll();
    }


    public void deleteById(long id) {
        rdvRepository.deleteById(id);
    }
    public void saveRDV(RDV rdv) {
        Optional<RDV> existingRDV = rdvRepository.findByDateAndHeure(rdv.getDate(), rdv.getHeure());
        if (existingRDV.isPresent()) {
            // Le RDV existe déjà, vous pouvez renvoyer une erreur ou afficher un message d'erreur
            // selon vos besoins
            // ...
            throw new RuntimeException("Le rendez-vous existe déjà !");
        }

        rdvRepository.save(rdv);
    }



    public RDV getRDVById(long id) {
        return rdvRepository.findById(id).get();
    }
    public void deleteRDVById(long id) {
        rdvRepository.deleteById(id);
    }
    @Transactional
    public void deleteByUserId(int userId) {
        rdvRepository.deleteByUserId(userId);
    }
}
