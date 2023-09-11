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
@Table(name="it_item")
public class Item extends BackboneElement {

    public enum TypeCode {
        source("source"),
        alternate("alternate"),
        historical("historical");
        private String value;

        private TypeCode(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "it_type")
    private TypeCode type;

    @NotNull
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "it_resource", referencedColumnName= "id")
    private Reference resource;


}
