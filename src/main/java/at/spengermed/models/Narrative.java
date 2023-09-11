package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name= "n_narrative")
@Builder
public class Narrative extends Element{

    public enum NarrativeCode{

        generated("generated"),
        extensions("extensions"),
        additional("additional"),
        abated("abated"),
        empty("empty");

        private String value;

        private NarrativeCode(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

    }
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="n_status")
    private NarrativeCode status;

    @NotNull
    @Lob
    @Column(name="n_div", nullable = false)
    private String div;
}
