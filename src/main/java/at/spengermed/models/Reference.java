package at.spengermed.models;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "r_reference")
@Builder
public class Reference extends Element{

   //@Column(name = "r_reference")
   //private String reference;

    @Column(name = "re_reference")
    private String reference;

    @Column(name = "r_type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "r_i_id", referencedColumnName = "id")
    private List<Identifier> identifier = new ArrayList<>();

    @Column(name = "r_display")
    private String dislay;


}