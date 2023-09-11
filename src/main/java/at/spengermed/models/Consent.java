package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "co_consent")
@Builder

public class Consent extends DomainResource{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="i_co_id", referencedColumnName = "id")
    private List<Identifier> identifier= new ArrayList<>();



    public enum StatusCode{
        draft("draft"),
        proposed("proposed"),
        active("active"),
        rejected("rejected"),
        inactive("inactive"),
        eie("entered-in-error");


        private String value;

        private StatusCode(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name= "co_status")
    private StatusCode status;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="cc_co_id", referencedColumnName = "id")
    private CodeableConcept scope= new CodeableConcept();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="re_co_id", referencedColumnName = "id")
    private List<Reference> patient= new ArrayList<>();

    @Column(name="co_datetime")
    private LocalDateTime dateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="at_co_id", referencedColumnName = "id")
    private Attachment sourceAttachment= new Attachment();

    @Column(name = "co_sourcedatetime")
    private LocalDateTime sourceDateTime;

}
