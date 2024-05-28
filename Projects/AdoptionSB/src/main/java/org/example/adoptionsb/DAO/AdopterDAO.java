package org.example.adoptionsb.DAO;

import org.example.adoptionsb.Classes.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AdopterDAO extends JpaRepository<Adopter, Integer> {
    @Query("select c from Adopter c where c.adopterName = :name")
    public List<Adopter> findByName(@Param("name") String name);
}
