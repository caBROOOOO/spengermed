package at.spengermed.models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="is_imagingstudy")

public class Imagingstudy extends DomainResource{

    public enum StatusCode{
        registered, available, cancelled, entered, unknown;
    }
    @Enumerated(EnumType.STRING)
    @Column(name="is_status")
    private StatusCode status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "is_re_id", referencedColumnName = "id")
    private Reference subject;

    @Column(name="is_started")
    private LocalDateTime started;

    @Column (name="is_number_Of_Series")
    private Integer numberOfSeries;

   // @Column(name="is_numberOfSeries")
    //private Integer numberOfSeries;

    @Column(name="is_description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "is_se_id", referencedColumnName = "id")
    private List<Series> series = new ArrayList<Series>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "is_i_id", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<Identifier>();
}

