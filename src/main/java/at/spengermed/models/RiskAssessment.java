package at.spengermed.models;

import com.sun.istack.NotNull;
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
@Table(name="ra_riskassessment")
public class RiskAssessment extends DomainResource {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="ra_indenti_id", referencedColumnName = "id")
    private List<Identifier> identifier= new ArrayList<>();

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "ra_parent", referencedColumnName= "id")
    private Reference parent;

    public enum Status {
        registered("registered"),
        preliminary("preliminary"),
        realfinal("final"),
        amended("amended");
        private String value;
        private Status(String value) {
            this.value = value;
        }
        public String toString() {
            return this.value;
        }
    }
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ra_status")
    private Status status;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "ra_prediction", referencedColumnName= "id")
    private List<Prediction> prediction = new ArrayList<>();

}
