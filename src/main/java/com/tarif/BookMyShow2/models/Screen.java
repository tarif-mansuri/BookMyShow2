package com.tarif.BookMyShow2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.tarif.BookMyShow2.models.enums.Feature;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}

/*
Screen --> Seat
1 --> M
1 <-- 1
 */
