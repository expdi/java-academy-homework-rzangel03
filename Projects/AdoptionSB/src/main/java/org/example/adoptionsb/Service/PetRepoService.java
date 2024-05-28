package org.example.adoptionsb.Service;

import org.example.adoptionsb.Classes.Pet;
import org.example.adoptionsb.DAO.PetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetRepoService {
    @Autowired
    public PetDAO petDAO;

    public Pet addPet(Pet pet) {
        return petDAO.save(pet);
    }

    public List<Pet> getAllPet() {
        return petDAO.findAll();
    }

    public Pet findById(int id) {
        return petDAO.findById(id).orElse(null);
    }

    public boolean deletePet(int id) {
        Pet pet = petDAO.findById(id).orElse(null);
        if (pet != null) {
            petDAO.delete(pet);
            return true;
        }
        return false;
    }

    public boolean updatePet(Pet pet) {
        Pet oldPet = petDAO.findById(pet.getIdPet()).orElse(null);
        if (oldPet != null) {
            petDAO.save(pet);
            return true;
        }
        return false;
    }
}
