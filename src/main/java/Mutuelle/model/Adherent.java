package Mutuelle.model;


import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "adherents")
public class Adherent implements Serializable {

    @Id
    @NotBlank
    @Length(max=4)
    private int mat_ad;

    @NotBlank
    @Size(max = 100)
    private String nom_prenom ;

    @NotBlank
    @Length(max=8)
    @Positive
    private long num_cin ;

    @NotBlank
    @Length(max=2,min=2)
    @Positive
    private int age ;

    @NotBlank
    @DateTimeFormat
    private Date date_nai ;

    @NotBlank
    private boolean typeAdherant ;

    @Min(0)
    private Float salaire ;

    @Ignore
    private Float cotisation ;

    @DateTimeFormat
    private Date date_cotisation ;


    @ManyToOne
    @JoinColumn(name = "code_li")
    @Length(max = 2)
    @Positive
    private LieuTrav lieuTrav;

    @ManyToOne
    @JoinColumn(name = "code_pl")
    @Length(max = 2)
    @Positive
    private Plafond plafond;

    @OneToOne
    @JoinColumn(name="id_conjoint")
    private Conjoint conjoint ;

    public Conjoint getConjoint() {
        return conjoint;
    }

    public void setConjoint(Conjoint conjoint) {
        this.conjoint = conjoint;
    }

    public LieuTrav getLieuTrav() {
        return lieuTrav;
    }

    public void setLieuTrav(LieuTrav lieuTrav) {
        this.lieuTrav = lieuTrav;
    }

    public Plafond getPlafond() {
        return plafond;
    }

    public void setPlafond(Plafond plafond) {
        this.plafond = plafond;
    }

    public int getMat_ad() {
        return mat_ad;
    }

    public void setMat_ad(int mat_ad) {
        this.mat_ad = mat_ad;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public long getNum_cin() {
        return num_cin;
    }

    public void setNum_cin(long num_cin) {
        this.num_cin = num_cin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate_nai() {
        return date_nai;
    }

    public void setDate_nai(Date date_nai) {
        this.date_nai = date_nai;
    }
}
