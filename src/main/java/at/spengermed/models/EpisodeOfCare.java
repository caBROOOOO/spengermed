package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eoc_episodeofcare")
@Builder

public class EpisodeOfCare extends DomainResource {

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "eoc_identifier", referencedColumnName= "id")
    private List<Identifier> identifier = new ArrayList<>();

    public enum Status {
        planned("planned"),
        waitlist("waitlist"),
        active("active"),
        onhold("onhold"),
        finished("finished"),
        cancelled("cancelled"),
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
    @Column(name = "eoc_status")
    private Status status;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name= "eoc_statushistory", referencedColumnName= "id")
    private List<statusHistory> statusHistory = new ArrayList<>();
}
