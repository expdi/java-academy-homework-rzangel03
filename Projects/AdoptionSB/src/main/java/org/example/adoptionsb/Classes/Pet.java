package org.example.adoptionsb.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpet")
    private int idPet;

    @Column(name = "type")
    private String petType;
    @Column(name = "name")
    private String petName;
    @Column(name = "breedtype")
    private String petBreedType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idadopter")
    private Adopter adopter;

    public Pet() {

    }

    public Pet(String petType, String petName, String petBreedType) {
        super();
        this.petType = petType;
        this.petName = petName;
        this.petBreedType = petBreedType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return idPet == pet.idPet && Objects.equals(petType, pet.petType) && Objects.equals(petName, pet.petName) && Objects.equals(petBreedType, pet.petBreedType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPet, petType, petName, petBreedType);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "idPet=" + idPet +
                ", petType='" + petType + '\'' +
                ", petName='" + petName + '\'' +
                ", petBreedType='" + petBreedType + '\'' +
                '}';
    }
}
