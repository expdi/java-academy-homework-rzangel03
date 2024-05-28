package org.example.adoptionsb.Service;

import org.example.adoptionsb.Classes.Adopter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles({"h2"})
@SpringBootTest
@Transactional
@Tag("integration")
class AdoptionRepoServiceTest {
    private Adopter adopter;
    private Adopter adopter2;

    @Autowired
    private AdoptionRepoService adoptionRepoService;

    @BeforeEach
    public void setup() {
        adopter = new Adopter("Angel", "8594781526", null);
        adopter2 = new Adopter("Miguel", "4579548514", null);
    }

    @Test
    public void testGetAll() {
        Adopter newAdopter = adoptionRepoService.addAdopter(adopter);
        Adopter result = adoptionRepoService.findById(newAdopter.getIdAdopter());

        assertEquals(adopter.getAdopterName(), result.getAdopterName());
        assertEquals(10, adoptionRepoService.getAllAdopters().size());
        System.out.println("result = " + result);
    }

    @Test
    public void testDeleteAdopter() {
        Adopter adopter1 = adoptionRepoService.addAdopter(adopter);
        Adopter adopter3 = adoptionRepoService.addAdopter(adopter2);

        assertEquals(11, adoptionRepoService.getAllAdopters().size());

        adoptionRepoService.deleteAdopter(adopter1.getIdAdopter());

        List<Adopter> adopters = adoptionRepoService.getAllAdopters();
        assertEquals(10, adopters.size());
        assertEquals(adopter2.getAdopterName(), adoptionRepoService.findById(adopter2.getIdAdopter()).getAdopterName());
    }

    @Test
    public void testDeleteNonExistentAdopter() {
        Adopter adopter1 = adoptionRepoService.addAdopter(adopter);
        Adopter adopter3 = adoptionRepoService.addAdopter(adopter2);

        assertEquals(11, adoptionRepoService.getAllAdopters().size());

        // Nonexistent id
        adoptionRepoService.deleteAdopter(9999);

        assertEquals(11, adoptionRepoService.getAllAdopters().size());
    }

    @Test
    public void testUpdateAdopter() {
        Adopter adopter1 = adoptionRepoService.addAdopter(adopter);
        System.out.println(adoptionRepoService.getAllAdopters());
        assertEquals(10, adoptionRepoService.getAllAdopters().size());

        adopter1.setAdopterName("Angel Updated");
        adoptionRepoService.updateAdopter(adopter1);
        List<Adopter> adopters = adoptionRepoService.getAllAdopters();
        System.out.println(adopters);
        assertEquals(10, adoptionRepoService.getAllAdopters().size());
        assertEquals(adopter.getAdopterName(), adoptionRepoService.findById(adopter1.getIdAdopter()).getAdopterName());
    }

    @Test
    public void testGetAdopterByName() {
        assertNotNull(adoptionRepoService.getAdoptersByName("James"));
    }
}