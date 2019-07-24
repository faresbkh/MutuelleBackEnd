package Mutuelle.model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "enfants")
public class Enfant {
    public EnfantId getId() {
        return id;
    }

    public void setId(EnfantId id) {
        this.id = id;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @EmbeddedId
    private EnfantId id;

    @NotBlank
    @Size(max=100)
    private String nom_prenom ;


    @NotBlank
    @Length(min=1,max=2)
    @Positive
    private int age ;
}
