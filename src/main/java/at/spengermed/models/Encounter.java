package at.spengermed.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "en_encounter")
@Builder

public class Encounter extends DomainResource {


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="i_en_id", referencedColumnName = "id")
    private List<Identifier> identifier= new ArrayList<>();

    public enum Status{
        planned("planned"),
        arrived("arrived"),
        td("triaged"),
        ip("in-progress"),
        ol("finished"),
        cancelled("cancelled");

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
    @Column(name= "en_status")
    private Encounter.Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="sh_en_id", referencedColumnName = "id")
    private List<statusHistory> statusHistory= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="t_en_id", referencedColumnName = "id")
    private List<CodeableConcept> type= new ArrayList<>();

    @OneToOne
    @JoinColumn(name ="sj_en_id", referencedColumnName = "id")
    private Reference subject;

    @OneToMany
    @JoinColumn(name ="eoc_en_id", referencedColumnName = "id")
    private List<Reference> episodeOfCare=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="pp_en_id", referencedColumnName = "id")
    private List<Participant> participant= new ArrayList<>();

    @OneToMany
    @JoinColumn(name ="app_en_id", referencedColumnName = "id")
    private List<Reference> appointment=new ArrayList<>();

    @Embedded
    private Period period;

    @OneToMany
    @JoinColumn(name ="rr_en_id", referencedColumnName = "id")
    private List<Reference> reasonReference=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="d_en_id", referencedColumnName = "id")
    private List<Diagnosis> diagnosis= new ArrayList<>();

    @OneToOne
    @JoinColumn(name ="po_en_id", referencedColumnName = "id")
    private Reference partOf;

}