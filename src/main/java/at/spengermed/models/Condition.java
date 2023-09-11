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
@Table(name="cd_condition")
@Builder
public class Condition extends DomainResource{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "i_cd_id", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cc_clinicalstatus", referencedColumnName = "id")
    public CodeableConcept clinicalStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cc_verificationstatus", referencedColumnName = "id")
    public CodeableConcept verificationStatus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cc_category", referencedColumnName = "id")
    public List<CodeableConcept> category = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cc_severity", referencedColumnName = "id")
    public CodeableConcept severity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cc_code", referencedColumnName = "id")
    public CodeableConcept code;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cc_bodysite", referencedColumnName = "id")
    public List<CodeableConcept> bodySite = new ArrayList<>();

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cd_re_subject_patient", referencedColumnName = "id")
    public Reference subject;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_re_encounter", referencedColumnName = "id")
    public Reference encounter;

}