package org.example.adoptionsb.Classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class AdopterPet {
    private int idAdopter;
    private String adopterName;
    private String adopterPhoneNumber;
    private LocalDate adoptionDate;
    private int idPet;
    private String petType;
    private String petName;
    private String petBreedType;

    public AdopterPet(String adopterName, String adopterPhoneNumber, LocalDate adoptionDate, String petType, String petName, String petBreedType) {
        this(0, 0, adopterName, adopterPhoneNumber, adoptionDate, petType, petName, petBreedType);
    }

    public AdopterPet(int idAdopter, int idPet, String adopterName, String adopterPhoneNumber, LocalDate adoptionDate, String petType, String petName, String petBreedType) {
        this.idAdopter = idAdopter;
        this.idPet = idPet;
        this.adopterName = adopterName;
        this.adopterPhoneNumber = adopterPhoneNumber;
        this.adoptionDate = adoptionDate;
        this.petType = petType;
        this.petName = petName;
        this.petBreedType = petBreedType;
    }
}
