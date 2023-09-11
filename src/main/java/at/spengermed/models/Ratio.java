package at.spengermed.models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="rt_ratio")


public class Ratio extends Element {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rt_numerator", referencedColumnName = "id")
    private Quantity numerator;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rt_dominator", referencedColumnName = "id")
    private Quantity denominator;

}