package at.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="rea_reaction")
public class Reaction extends BackboneElement {

    @Column(name = "rea_date")
    private LocalDateTime date;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "rea_detail", referencedColumnName= "id")
    private Reference detail;

    @Column(name = "rea_reported")
    private Boolean reported;

}
