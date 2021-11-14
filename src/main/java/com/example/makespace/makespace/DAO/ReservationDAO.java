package com.example.makespace.makespace.DAO;

import com.example.makespace.makespace.Entity.Reservation;

import java.util.List;

public interface ReservationDAO {
    List<String> getReservation(String startTime, String endTime);

    Integer bookReservation(Reservation reservation);

}
