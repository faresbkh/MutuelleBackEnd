package Mutuelle.payload;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class LieuTravRequest {
    @NotNull
    @Max(99)
    @Min(0)
    private int codeLieu;


    @Override
    public String toString() {
        return "LieuTravRequest{" +
                "codeLieu=" + codeLieu +
                ", libeleLieu='" + libeleLieu + '\'' +
                '}';
    }

    @NotNull
    private String libeleLieu ;

    public LieuTravRequest(@NotNull @Max(99)
                           @Min(0) int codeLieu, @NotNull String libeleLieu) {
        this.codeLieu = codeLieu;
        this.libeleLieu = libeleLieu;
    }


    public int getCodeLieu() {
        return codeLieu;
    }

    public void setCodeLieu(int codeLieu) {
        codeLieu = codeLieu;
    }

    public String getLibeleLieu() {
        return libeleLieu;
    }

    public void setLibeleLieu(String libeleLieu) {
        this.libeleLieu = libeleLieu;
    }
}
