package at.spengermed.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="lin_linkage")
public class Linkage extends DomainResource {

    @Column(name = "lin_active")
    private Boolean active;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "lin_author", referencedColumnName= "id")
    private Reference author;

    @NotNull
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "lin_item", referencedColumnName= "id")
    private List<Item> itemList = new ArrayList<>();

}
