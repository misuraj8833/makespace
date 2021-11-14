package com.example.makespace.makespace.HelperPackage;

import com.example.makespace.makespace.DAO.ReservationDAOImpl1;
import com.example.makespace.makespace.Entity.Reservation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BookingHelperImplTest {

    @Mock
    ReservationDAOImpl1 reservationDAO;

    @Mock
    VacancyHelperImpl vacancyHelper;

    @InjectMocks
    BookingHelperImpl bookingHelper;

    @Test
    void driveBooking() {
        //given
        int room_id = 3;
        String start_time="15:00";
        String end_time="18:45";
        String noOfPersons = "9";
        String stubRoomName = "G-MANSION";
        List<String> stubRoomList = new ArrayList<>();
        stubRoomList.add("C-CAVE");
        stubRoomList.add("D-Tower");
        stubRoomList.add("G-Mansion");
        Reservation reservation = new Reservation(room_id,start_time,end_time);
        given(reservationDAO.bookReservation(reservation)).willReturn(room_id);
        given(vacancyHelper.driveVacancy(start_time,end_time)).willReturn(stubRoomList);
        //when
        String returnedRoomName = bookingHelper.driveBooking(start_time,end_time,noOfPersons);
        //then
        assertEquals(stubRoomName,returnedRoomName);
    }
}