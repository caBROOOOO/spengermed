package at.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="me_medication")
public class Medication extends DomainResource {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "me_identi_id", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "me_code", referencedColumnName = "id")
    private CodeableConcept code;

    public enum Status {
        active("active"),
        inactive("inactive"),
        enteredinerror("entered-in-error");
        private String value;

        private Status(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "me_status")
    private Status status;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "me_manufacturer", referencedColumnName= "id")
    private Reference manufacturer;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "me_form", referencedColumnName= "id")
    private CodeableConcept form;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "me_amount", referencedColumnName = "id")
    private Ratio amount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "me_ingredient", referencedColumnName = "id")
    private List<Ingredient> ingredient = new ArrayList<>();

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "me_batch", referencedColumnName= "id")
    private Batch batch;

}
