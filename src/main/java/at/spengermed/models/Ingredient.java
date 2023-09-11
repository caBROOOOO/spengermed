package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="ing_ingredient")
public class Ingredient extends BackboneElement {

    @NotNull // wegen NotNull beides importieren
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "ing_itemcodeableconcept", referencedColumnName= "id")
    private CodeableConcept itemCodeableConcept;

    @NotNull // wegen NotNull beides importieren
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "ing_itemreference", referencedColumnName= "id")
    private Reference itemReference;

    @Column(name = "ing_isactive")
    private boolean isActive;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "ing_strength", referencedColumnName= "id")
    private Ratio strength;

}