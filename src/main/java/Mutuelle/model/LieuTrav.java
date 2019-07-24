package Mutuelle.model;


import Mutuelle.payload.LieuTravRequest;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lieu_travail")
public class LieuTrav {

    @Id
    @NotNull
    @Column(name = "code_li")
    @Max(99)
    @Min(0)
    private int code_li ;


    @NotNull
    @Column(name = "lib_lieu")
    private String lib_lieu ;

    public LieuTrav() {
    }

    public LieuTrav(LieuTravRequest lieureq)
    {
        this.code_li= lieureq.getCodeLieu();
        this.lib_lieu=lieureq.getLibeleLieu();
    }

    public int getCode_li() {
        return code_li;
    }

    public void setCode_li(int code_li) {
        this.code_li = code_li;
    }

    public String getLib_lieu() {
        return lib_lieu;
    }

    public void setLib_lieu(String lib_lieu) {
        this.lib_lieu = lib_lieu;
    }
}
