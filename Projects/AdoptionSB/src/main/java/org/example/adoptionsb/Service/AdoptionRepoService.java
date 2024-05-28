package org.example.adoptionsb.Service;

import org.example.adoptionsb.Classes.Adopter;
import org.example.adoptionsb.DAO.AdopterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionRepoService {
    @Autowired
    private AdopterDAO adopterDAO;


    public Adopter addAdopter(Adopter adopter) {
        return adopterDAO.save(adopter);
    }

    public boolean deleteAdopter(int id) {
        Adopter adopter = adopterDAO.findById(id).orElse(null);
        if (adopter != null) {
            adopterDAO.delete(adopter);
            return true;
        }
        return false;
    }

    public boolean updateAdopter(Adopter adopter) {
        Adopter oldAdopter = adopterDAO.findById(adopter.getIdAdopter()).orElse(null);
        if (oldAdopter != null) {
            adopterDAO.save(adopter);
            return true;
        }
        return false;
    }

    public Adopter findById(int id) {
        return adopterDAO.findById(id).orElse(null);
    }

    public List<Adopter> getAllAdopters() {
        return adopterDAO.findAll();
    }

    public AdopterDAO getAdopterDAO() {
        return adopterDAO;
    }

    public void setAdopterDAO(AdopterDAO adopterDAO) {
        this.adopterDAO = adopterDAO;
    }

    public List<Adopter> getAdoptersByName(String name) {
        return this.adopterDAO.findByName(name);
    }

}
