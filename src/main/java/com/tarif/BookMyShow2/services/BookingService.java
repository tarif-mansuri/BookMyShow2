package com.tarif.BookMyShow2.services;

import com.tarif.BookMyShow2.dtos.BookingRequestDTP;
import com.tarif.BookMyShow2.exceptions.SHowSeatNotFoundException;
import com.tarif.BookMyShow2.exceptions.ShowNotFoundException;
import com.tarif.BookMyShow2.exceptions.UserNotFoundException;
import com.tarif.BookMyShow2.models.*;
import com.tarif.BookMyShow2.models.enums.BookingStatus;
import com.tarif.BookMyShow2.models.enums.ShowSeatStatus;
import com.tarif.BookMyShow2.repository.BookingRepository;
import com.tarif.BookMyShow2.repository.ShowRepository;
import com.tarif.BookMyShow2.repository.ShowSeatRepository;
import com.tarif.BookMyShow2.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    @Transactional
    public Booking bookTicket(Long userId, Long showId, List<Long> showSheetIds) {
        //Validate userId, showId and showSeatIds before making a booking
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found");
        }

        Optional<Show> optionalShow = showRepository.findById(showId);
        if (!optionalShow.isPresent()) {
            throw new ShowNotFoundException("Show not found");
        }

        List<ShowSheet> showSheets = showSeatRepository.findByIdAndLock(showSheetIds);
        if(showSheets.size() != showSheetIds.size()) {
            throw new SHowSeatNotFoundException("ShowSeats not found");
        }

        //u1--> {1,2,3,4}
        //u2--> {1,3,5}
        //check if all seats are available
        for(ShowSheet showSheet : showSheets) {
            if(showSheet.getShowSheetStatus() != ShowSeatStatus.AVAILABLE){
                throw new SHowSeatNotFoundException("ShowSeats not found");
            }
        }
        //Before we proceed for payment, mark all seats as blocked in DB
        //We will ask for payments, we shall give user time to make payments, least 5 minutes
        for(ShowSheet showSheet : showSheets) {
            showSheet.setShowSheetStatus(ShowSeatStatus.BLOCKED);
        }
        showSeatRepository.saveAll(showSheets);
        //Book the tickets
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setBookingNumber("BOOKING_" + userId + "_" + showId);
        booking.setUser(optionalUser.get());

        //User makes payment --> either payment fails or succeeds
        //Assume your payment got failed

        Payment p1 = new Payment();
        //if payment is unsuccessful
        //throe new PaymentUnsuccessfulException("payment failed");
        //Rollback all old transaction

        booking.setBookingStatus(BookingStatus.FAILED);
        for(ShowSheet showSheet : showSheets) {
            showSheet.setShowSheetStatus(ShowSeatStatus.AVAILABLE);
        }
        showSeatRepository.saveAll(showSheets);
        return booking;
    }

    public List<ShowSheet> getShowSheets() {
        List<ShowSheet> showSeats = showSeatRepository.findAll();
        return showSeats;
    }
}
