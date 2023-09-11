package at.spengermed.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "r_resource")
public abstract class Resource {

    @Pattern(regexp = "[A-Za-z0-9\\-\\.]{1,64}")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name="uuid2",strategy = "uuid2")
    @Column(name="id")
    private String id;

}
