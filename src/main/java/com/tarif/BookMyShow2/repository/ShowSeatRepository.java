package com.tarif.BookMyShow2.repository;

import com.tarif.BookMyShow2.models.ShowSheet;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSheet, Long> {

    /*
    Suppose User1 is booking Seat num 1,5, 7
    and User2 is booking seat num 2, 6,8
     */

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT ss FROM ShowSheet ss WHERE ss.id IN :ids")
    public List<ShowSheet> findByIdAndLock(List<Long> ids);
}
