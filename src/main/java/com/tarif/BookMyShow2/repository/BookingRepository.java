package com.tarif.BookMyShow2.repository;

import com.tarif.BookMyShow2.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
