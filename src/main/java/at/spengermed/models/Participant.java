package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pp_participant")
@Builder
public class Participant extends BackboneElement {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="t_pp_id", referencedColumnName = "id")
    private List<CodeableConcept> type= new ArrayList<>();

    @Embedded
    private Period period;

    @OneToOne
    @JoinColumn(name ="in_pp_id", referencedColumnName = "id")
    private Reference individual;


}
