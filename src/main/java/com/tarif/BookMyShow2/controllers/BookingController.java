package com.tarif.BookMyShow2.controllers;

import com.tarif.BookMyShow2.dtos.BookingRequestDTP;
import com.tarif.BookMyShow2.dtos.BookingResponseDTO;
import com.tarif.BookMyShow2.dtos.ResponseStatus;
import com.tarif.BookMyShow2.dtos.ShowSeatResponseDTO;
import com.tarif.BookMyShow2.models.Booking;
import com.tarif.BookMyShow2.models.ShowSheet;
import com.tarif.BookMyShow2.services.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public BookingResponseDTO bookTicket(BookingRequestDTP request) {
        Booking booking = bookingService.bookTicket(request.getUserId(), request.getShowId(), request.getShowSheetIds());
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        bookingResponseDTO.setBooking(booking);
        bookingResponseDTO.setStatus(ResponseStatus.SUCCESS);
        return bookingResponseDTO;
    }

    @GetMapping("/allshowseats")
    public ShowSeatResponseDTO getShowSheats(){
        List<ShowSheet> showSheets = bookingService.getShowSheets();
        ShowSeatResponseDTO showSeatResponseDTO = new ShowSeatResponseDTO();
        showSeatResponseDTO.setShowSheats(showSheets);
        showSeatResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        return showSeatResponseDTO;
    }
}
