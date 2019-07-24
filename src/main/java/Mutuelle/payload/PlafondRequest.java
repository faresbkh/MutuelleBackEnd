package Mutuelle.payload;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PlafondRequest {
    @NotNull
    @Min(0)
    @Max(100)
    private int codePlafond ;
    
    @NotNull
    @Min(0)
    private float montant ;

    @Override
    public String toString() {
        return "PlafondRequest{" +
                "codePlafond=" + codePlafond +
                ", montant=" + montant +
                '}';
    }

    public int getCodePlafond() {
        return codePlafond;
    }

    public void setCodePlafond(int codePlafond) {
        this.codePlafond = codePlafond;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
}
