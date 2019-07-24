package Mutuelle.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnfantId implements Serializable {

    @NotBlank
    @Length(max = 2)
    @Positive
    @Column(name = "code_en")
    private int code_en;

    public int getCode_en() {
        return code_en;
    }

    public void setCode_en(int code_en) {
        this.code_en = code_en;
    }

    public Adherent getParent() {
        return parent;
    }

    public void setParent(Adherent parent) {
        this.parent = parent;
    }

    @ManyToOne
    @JoinColumn(name = "mat_ad")
    @Length(max = 4)
    @Positive
    private Adherent parent;

    public EnfantId() {

    }

    public EnfantId(Adherent parent, int mat_ad) {
            this.parent = parent;
            this.code_en = code_en;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnfantId enfantId = (EnfantId) o;
        return code_en == enfantId.code_en &&
                Objects.equals(parent, enfantId.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code_en, parent);
    }
}
