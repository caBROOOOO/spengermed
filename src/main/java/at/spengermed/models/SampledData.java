package at.spengermed.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@Table(name="sd_sampleddata")
public class SampledData extends Element{
    @NotNull
    @Column(name = "sd_origin")
    private int origin;

    @NotNull
    @Column(name = "sd_period")
    private float period;


    @Column(name = "sd_factor")
    private float factor;

    @Column(name = "sd_lowerlimit")
    private float lowerLimit;

    @Column(name = "sd_upperlimit")
    private float upperLimit;

    @NotNull
    @Column(name = "sd_dimensions")
    private int dimensions;

    @Column(name = "sd_data")
    private String data;
}

