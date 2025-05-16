package com.tarif.BookMyShow2.dtos;

import com.tarif.BookMyShow2.models.ShowSheet;
import lombok.Data;

import java.util.List;

@Data
public class ShowSeatResponseDTO {
    private List<ShowSheet> showSheats;
    private ResponseStatus responseStatus;

}
