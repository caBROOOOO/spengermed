package at.spengermed.models;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="im_immunization")
public class Immunization extends DomainResource {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "im_identi_id", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();

    public enum Status {
        completed("completed "),
        notdone("not-done"),
        enteredinerror("entered-in-error");
        private String value;

        private Status(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "im_status")
    private Status status;

    @NotNull
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "im_vaccinecode", referencedColumnName= "id")
    private CodeableConcept vaccineCode;

    @NotNull
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "im_patient", referencedColumnName= "id")
    private Reference patient;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "im_encounter", referencedColumnName= "id")
    private Reference encounter;

    @NotNull
    @Column(name = "im_occurrencedatetime")
    private LocalDateTime occurrenceDateTime;

    @NotNull
    @Column(name = "im_occurrencestring")
    private String occurrenceString;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "im_manufacturer", referencedColumnName= "id")
    private Reference manufacturer;

    @Column(name = "im_lotnumber")
    private String lotNumber;

    @Column(name = "im_expirationdate")
    private LocalDate expirationDate;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "im_site", referencedColumnName= "id")
    private CodeableConcept site;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "im_dosequantity", referencedColumnName= "id")
    private Quantity doseQuantity;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "im_performer", referencedColumnName= "id")
    private List<Performer> performer = new ArrayList<>();

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "im_reaction", referencedColumnName= "id")
    private List<Reaction> reaction = new ArrayList<>();

}