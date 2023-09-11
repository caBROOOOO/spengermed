package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sh_statushistory")
@Builder
public class statusHistory extends BackboneElement {

    public enum Status{
        planned("planned"),
        arrived("arrived"),
        td("triaged"),
        ip("in-progress"),
        ol("finished"),
        cancelled("cancelled"),
        waitlist("waitlist"),
        active("active"),
        onhold("onhold"),
        enteredinerror("entered-in-error");

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
    @Column(name= "sh_status")
    private statusHistory.Status status;

    @NotNull
    @Embedded
    private Period period;

}