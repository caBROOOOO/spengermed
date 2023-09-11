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
@Table(name = "g_group")
@Builder
public class Group extends BackboneElement {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="c_m_id", referencedColumnName = "id")
    private List<CodeableConcept> code = new ArrayList<>();

    @Column(name = "m_description")
    private String description;
}
