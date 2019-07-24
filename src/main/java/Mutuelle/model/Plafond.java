package Mutuelle.model;

import Mutuelle.payload.PlafondRequest;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "plafond")
public class Plafond{

    @Id
    @NotBlank
    @Column(name = "code_pl")
    @Length(max = 2)
    private int code_pl ;


    @NotBlank
    @Column(name = "montant")
    private float montant ;

    public int getCode_pl() {
        return code_pl;
    }

    public Plafond(PlafondRequest plr) {
        this.code_pl=plr.getCodePlafond() ;
        this.montant=plr.getMontant();
    }

    public void setCode_pl(int code_pl) {
        this.code_pl = code_pl;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
}
