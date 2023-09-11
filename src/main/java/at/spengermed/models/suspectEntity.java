package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "se_suspectentity")
@Builder
public class suspectEntity extends BackboneElement {
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="r_se_id", referencedColumnName = "id")
    private Reference instance;
}


