package org.example.adoptionsb.Controller;

import org.example.adoptionsb.Classes.Adopter;
import org.example.adoptionsb.Service.AdoptionRepoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/adopter")
public class AdopterController {
    private final UriCreator uriCreator;
    private AdoptionRepoService adoptionService;

    public AdopterController(UriCreator uriCreator, AdoptionRepoService adoptionService) {
        this.uriCreator = uriCreator;
        this.adoptionService = adoptionService;
    }

    @GetMapping
    public ResponseEntity<?> getAdopterList() {
        List<Adopter> adopters = adoptionService.getAllAdopters();
        return ResponseEntity.ok(RestResultWrapper.ofValue(adopters));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdopter(@PathVariable("id") int id) {
        Adopter adopter = adoptionService.findById(id);
        if (adopter == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopter with id: " + id);
        }
        return ResponseEntity.ok(RestResultWrapper.ofValue(adopter));
    }

    @GetMapping("/byname/{name}")
    public ResponseEntity<?> getAdopterByName(@PathVariable("name") String name) {
        List<Adopter> adopter = adoptionService.getAdoptersByName(name);
        if (adopter == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopter with name: " + name);
        }
        return ResponseEntity.ok(RestResultWrapper.ofValue(adopter));
    }

    @PostMapping
    public ResponseEntity<?> addAdopter(@RequestBody Adopter adopter) {
        Adopter newAdopter = adoptionService.addAdopter(adopter);
        URI newUri = uriCreator.getUriFor(newAdopter.getIdAdopter());
        return ResponseEntity.created(newUri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdopter(@PathVariable("id") int id) {
        boolean result = adoptionService.deleteAdopter(id);
        if (!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopter with id:" + id);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> updateAdopter(@RequestBody Adopter adopter) {
        boolean result = adoptionService.updateAdopter(adopter);
        if (!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No adopter with id: " + adopter.getIdAdopter());
        }
        return ResponseEntity.noContent().build();
    }
}
