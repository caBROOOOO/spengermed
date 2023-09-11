package at.spengermed.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="ra_range")
public class Range extends  Element{

    @Column(name = "ra_low")
    private int low;

    @Column(name = "ra_high")
    private int high;
}
