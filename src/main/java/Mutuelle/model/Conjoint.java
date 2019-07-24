package Mutuelle.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "conjoint")
public class Conjoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conjoint")
    private  int id ;


    private boolean cotise ;

    @NotBlank
    @Length(max=8)
    @Positive
    private long num_cin ;

    @Length(max=4,min=4)
    private int annee_cot ;

    @NotBlank
    @Size(max=100)
    private String nom_prenom ;

    private float mont_cot ;


    public boolean isCotise() {
        return cotise;
    }

    public void setCotise(boolean cotise) {
        this.cotise = cotise;
    }

    public long getNum_cin() {
        return num_cin;
    }

    public void setNum_cin(long num_cin) {
        this.num_cin = num_cin;
    }

    public int getAnnee_cot() {
        return annee_cot;
    }

    public void setAnnee_cot(int annee_cot) {
        this.annee_cot = annee_cot;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public float getMont_cot() {
        return mont_cot;
    }

    public void setMont_cot(float mont_cot) {
        this.mont_cot = mont_cot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
