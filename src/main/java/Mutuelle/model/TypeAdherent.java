package Mutuelle.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


public class TypeAdherent {

    @Id
    @NotBlank
    @Length(max = 2)
    private int codeType ;

    @NotBlank
    @Size(max = 2)
    private String natureType ;

    @NotBlank
    @Size (max = 100)
    private String libeleType ;

    @Column(name = "cot_ret")
    private float cotRet ;

    @Column(name = "date_deb")
    private Date dateDeb ;

    @Column(name = "date_fin")
    private Date dateFin ;
}
