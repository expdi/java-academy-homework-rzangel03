package org.example.adoptionsb.Controller;

import org.example.adoptionsb.Classes.Pet;
import org.example.adoptionsb.Service.PetRepoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final UriCreator uriCreator;
    private PetRepoService petRepoService;

    public PetController(UriCreator uriCreator, PetRepoService petRepoService) {
        this.uriCreator = uriCreator;
        this.petRepoService = petRepoService;
    }

    @GetMapping
    public ResponseEntity<?> getPetList() {
        List<Pet> pet = petRepoService.getAllPet();
        return ResponseEntity.ok(RestResultWrapper.ofValue(pet));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPet(@PathVariable("id") int id) {
        Pet pet = petRepoService.findById(id);
        if (pet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pet with id: " + id);
        }
        return ResponseEntity.ok(RestResultWrapper.ofValue(pet));
    }

    @PostMapping
    public ResponseEntity<?> addPet(@RequestBody Pet pet) {
        Pet newPet = petRepoService.addPet(pet);
        URI newUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pet.getIdPet())
                .toUri();
        return ResponseEntity.created(newUri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") int id) {
        boolean result = petRepoService.deletePet(id);
        if (!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pet with id:" + id);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> updatePet(@RequestBody Pet pet) {
        boolean result = petRepoService.updatePet(pet);
        if (!result) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("No pet with id: " + pet.getIdPet());
        }
        return ResponseEntity.noContent().build();
    }
}
