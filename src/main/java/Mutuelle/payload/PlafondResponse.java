package Mutuelle.payload;


import Mutuelle.model.Plafond;

public class PlafondResponse {
    private int codePlafond ;
    private float montant ;

    public PlafondResponse(int codePlafond, float montant) {
        this.codePlafond = codePlafond;
        this.montant = montant;
    }
    public static PlafondResponse mapPlafond(Plafond pl)
    {
        return new PlafondResponse(pl.getCode_pl(),pl.getMontant());
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
