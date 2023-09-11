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
@Table(name="pc_pricecomponent")
public class priceComponent extends BackboneElement {

    public enum NameCode {
        //base | surcharge | deduction | discount | tax | informational
        base("base"),
        surcharge("surcharge"),
        deduction("deduction"),
        discount("discount"),
        tax("tax"),
        informational("informational");

        private String value;

        private NameCode(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "pc_type")
    private NameCode type;

}
