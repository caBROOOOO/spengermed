package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="pe_performer")
public class Performer extends BackboneElement {

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "pe_function", referencedColumnName= "id")
    private CodeableConcept function;

    @NotNull
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "pe_actor", referencedColumnName= "id")
    private Reference actor;

}
