package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="ob_observation")
public class Observation extends DomainResource{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="i_ob_id", referencedColumnName = "id")
    private List<Identifier> identifier= new ArrayList<>();

    public enum Status{
        registered ("registered"),
        preliminary ("preliminary"),
        finalreal("finalreal"),
        amended ("amended");

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
    @Column(name= "ob_status")
    private Observation.Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_cc_id", referencedColumnName = "id")
    private List<CodeableConcept> category;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "co_cc_id", referencedColumnName = "id")
    private CodeableConcept code;

    @OneToOne
    @JoinColumn(name ="su_re_id", referencedColumnName = "id")
    private Reference subject;

    @OneToOne
    @JoinColumn(name ="en_re_id", referencedColumnName = "id")
    private Reference encounter;

    @Column(name = "ed_name")
    private LocalDate effectiveDateTime;

    @Embedded
    @JoinColumn(name= "cn_name", referencedColumnName= "id")
    private Period effectivePeriod;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "p_performer", referencedColumnName= "id")
    private List<Reference> performer = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ob_valuquantity", referencedColumnName = "id")
    private Quantity valueQuantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ob_valuecodableconcept", referencedColumnName = "id")
    private CodeableConcept valuecodableconcept;


    @Column(name="ob_valuestring")
    private String valueString;

    @Column(name="ob_valueboolean")
    private Boolean valueBoolean;

    @Column(name="ob_valueinteger")
    private int valueInteger;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ob_valuerange", referencedColumnName = "id")
    private Range valueRange;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ob_valueratio", referencedColumnName = "id")
    private Ratio valueRatio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ob_valuesampleddata", referencedColumnName = "id")
    private SampledData valueSampledData;



    @Column(name = "ob_valuetime")
    private LocalTime valueTime;

    @Column(name = "ob_valuedatetime")
    private LocalDateTime valueDateTime;




}

