package at.spengermed.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="bat_batch")
public class Batch extends BackboneElement {

    @Column(name = "bat_lotNumber")
    private String lotNumber;

    @Column(name = "bat_expirationDate")
    private LocalDateTime expirationDate;
}
