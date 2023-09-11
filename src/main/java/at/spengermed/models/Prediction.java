package at.spengermed.models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="pre_prediction")
public class Prediction extends BackboneElement {

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "pre_outcome", referencedColumnName= "id")
    private CodeableConcept outcome;

    @Column(name = "pre_probabilityDecimal")
    private float probabilityDecimal;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "pre_probabilityRange", referencedColumnName= "id")
    private Range probabilityRange;


}
