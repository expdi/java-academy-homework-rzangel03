package org.example.adoptionsb.DAO;

import org.example.adoptionsb.Classes.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PetDAO extends JpaRepository<Pet, Integer> {
}
