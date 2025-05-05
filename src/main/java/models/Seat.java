package models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import models.enums.SeatType;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String number;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne
    private Screen screen;
}

/*
Seat --> Screen
1 --> 1
M <-->
 */
