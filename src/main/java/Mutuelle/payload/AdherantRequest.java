package Mutuelle.payload;

import java.util.Date;

public class AdherantRequest {
    private String nomPrenom ;
    private int matId ;
    private int numCin ;
    private int code_lieu ;
    private Date dateNaissance ;

    public AdherantRequest(String nomPrenom, int matId, int numCin, int code_lieu, Date dateNaissance) {
        this.nomPrenom = nomPrenom;
        this.matId = matId;
        this.numCin = numCin;
        this.code_lieu = code_lieu;
        this.dateNaissance = dateNaissance;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public int getMatId() {
        return matId;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    public int getNumCin() {
        return numCin;
    }

    public void setNumCin(int numCin) {
        this.numCin = numCin;
    }

    public int getCode_lieu() {
        return code_lieu;
    }

    public void setCode_lieu(int code_lieu) {
        this.code_lieu = code_lieu;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
