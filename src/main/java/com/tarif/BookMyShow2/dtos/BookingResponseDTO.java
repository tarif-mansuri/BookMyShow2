package com.tarif.BookMyShow2.dtos;

import com.tarif.BookMyShow2.models.Booking;
import lombok.Data;

@Data
public class BookingResponseDTO {
    private Booking booking;
    private ResponseStatus status;
}
