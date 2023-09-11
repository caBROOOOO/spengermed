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
@Table(name="se_series")

public class Series extends BackboneElement {

    @Column(name="se_uid")
    private String uid;

    @Column(name="se_number")
    private Integer number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="se_c_id", referencedColumnName = "id")
    private Coding modality;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "se_ce_id", referencedColumnName = "id")
   // private Coding modality;

}
