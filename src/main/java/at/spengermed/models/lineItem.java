package at.spengermed.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="li_lineitem")
public class lineItem extends BackboneElement{

    @Column(name = "li_sequence")
    private int sequence;

    @NotNull
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "li_r_chargeItemReference", referencedColumnName= "id")
    private Reference chargeItemReference;

    @NotNull
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "li_cc_chargeItemCodeableConcept", referencedColumnName= "id")
    private CodeableConcept chargeItemCodeableConcept;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "li_priceComponent", referencedColumnName= "id")
    private List<priceComponent> priceComponent = new ArrayList<>();


}
