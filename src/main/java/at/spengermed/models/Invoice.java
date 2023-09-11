package at.spengermed.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="in_invoice")
public class Invoice extends DomainResource{
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "in_li_lineitem", referencedColumnName= "id")
    private List<lineItem> lineItem = new ArrayList<>();
}

