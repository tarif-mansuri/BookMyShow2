package models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import models.enums.ShowSeatStatus;

@Getter
@Setter
@Entity
public class ShowSheet extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    private Long price;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSheetStatus;
}

/*
ShowSeat --> Show
1 --> 1
M <-- 1
 */
