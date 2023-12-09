package com.insha.Bookmyshow.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;
@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{

    private Time StartTime;
    private Time EndTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
