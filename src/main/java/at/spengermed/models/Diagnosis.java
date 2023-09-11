package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;
//import jakarta.validation.constraints.Positive;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "d_diagnosis")
@Builder
public class Diagnosis extends BackboneElement {

    @NotNull
    @OneToOne
    @JoinColumn(name ="c_d_id", referencedColumnName = "id")
    private Reference condition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="use_d_id", referencedColumnName = "id")
    private CodeableConcept use;

    @Column(name="d_rank")
    //@Positive geht bei mir net
    private Integer rank;
}