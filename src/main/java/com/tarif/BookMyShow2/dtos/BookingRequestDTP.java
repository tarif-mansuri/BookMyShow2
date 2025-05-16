package com.tarif.BookMyShow2.dtos;

import com.tarif.BookMyShow2.models.ShowSheet;
import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDTP {
    private Long userId;
    private Long showId;
    private List<Long> showSheetIds;
}
