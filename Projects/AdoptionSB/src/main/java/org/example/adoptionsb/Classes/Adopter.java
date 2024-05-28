package org.example.adoptionsb.Classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idadopter")
    private int idAdopter;
    @Column(name = "name")
    private String adopterName;
    @Column(name = "phonenumber")
    private String adopterPhoneNumber;
    @Column(name = "date")
    private LocalDate adoptionDate;

    @OneToMany(mappedBy = "adopter", cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    public Adopter(String adopterName, String adopterPhoneNumber, LocalDate adoptionDate) {
        this(0, adopterName, adopterPhoneNumber, adoptionDate);
    }

    public Adopter(int idAdopter, String adopterName, String adopterPhoneNumber, LocalDate adoptionDate) {
        this.idAdopter = idAdopter;
        this.adopterName = adopterName;
        this.adopterPhoneNumber = adopterPhoneNumber;
        this.adoptionDate = adoptionDate;
    }

    public Adopter() {

    }

    @Override
    public String toString() {
        return "Adopter{" +
                "idAdopter=" + idAdopter +
                ", adopterName='" + adopterName + '\'' +
                ", adopterPhoneNumber='" + adopterPhoneNumber + '\'' +
                ", adoptionDate=" + adoptionDate +
                "} " + super.toString();
    }
}
