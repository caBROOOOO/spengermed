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
@Table(name="qu_quantity")

public class Quantity extends Element{


    @Column(name="qu_value")
    private float value;

    public enum comparator{
        kl("<"),
        klgl("<="),
        grgl(">="),
        gr(">");




        private String value;

        private comparator(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name= "qu_comparator")
    private comparator comparator;

    @Column(name="qu_unit")
    private String unit;

    @Column(name="qu_system")
    private String system;

    @Column(name="qu_code")
    private String code;
}
