package at.spengermed.models;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="m_measure")
public class Measure extends DomainResource {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="i_m_id", referencedColumnName = "id")
    private List<Identifier> identifier= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="sc_m_id", referencedColumnName = "id")
    private List<CodeableConcept> subjectCodeableConcept= new ArrayList<>();

    @Column(name = "m_uri")
    private String uri;

    @Column(name = "m_version")
    private String version;

    @PastOrPresent(message = "Du bist noch nicht geboren ... SUS")
    @Column(name="m_date")
    private LocalDate date;




}
