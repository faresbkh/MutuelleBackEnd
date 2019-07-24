package Mutuelle.payload;

import Mutuelle.model.LieuTrav;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class LieuTravResponse {

    private int CodeLieu;

    @Override
    public String toString() {
        return "LieuTravResponse{" +
                "CodeLieu=" + CodeLieu +
                ", libeleLieu='" + libeleLieu + '\'' +
                '}';
    }

    private String libeleLieu ;

    public LieuTravResponse(@NotNull @Length(max = 2) int codeLieu, @NotNull String libeleLieu) {
        CodeLieu = codeLieu;
        this.libeleLieu = libeleLieu;
    }
    public static LieuTravResponse mapLieuTrav(LieuTrav li)
    {
        return new LieuTravResponse(li.getCode_li(),li.getLib_lieu());
    }

    public int getCodeLieu() {
        return CodeLieu;
    }

    public void setCodeLieu(int codeLieu) {
        CodeLieu = codeLieu;
    }

    public String getLibeleLieu() {
        return libeleLieu;
    }

    public void setLibeleLieu(String libeleLieu) {
        this.libeleLieu = libeleLieu;
    }
}
