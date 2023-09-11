package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.aspectj.apache.bcel.classfile.Code;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ae_adverseevent")
@Builder
public class AdverseEvent extends DomainResource {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "i_ae_id", referencedColumnName = "id")
    private Identifier identifier;

    public enum Code{
        actual("actual"),
        potential("potential");

        private String value;
        private Code(String value) {
            this.value = value;
        }
        public String toString() {
            return this.value;
        }
    }
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="ae_code")
    private Code code;

    @Column(name="ae_detected")
    private LocalDate detected;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cc_ae_id", referencedColumnName = "id")
    private CodeableConcept severity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="se_ae_id", referencedColumnName = "id")
    private List<suspectEntity> suspectEntity= new ArrayList<>();;

}
