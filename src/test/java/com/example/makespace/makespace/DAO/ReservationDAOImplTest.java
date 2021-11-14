package com.example.makespace.makespace.DAO;

import com.example.makespace.makespace.Entity.MeetingRoom;
import com.example.makespace.makespace.Entity.Reservation;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ReservationDAOImplTest {

    @Spy
    ReservationDAOImpl1 reservationDAO;

//    @Mock
//    SessionFactory sessionFactory;

    @Test
    void getReservation() {
        //given
        given(reservationDAO.getReservation(anyString(),anyString())).willCallRealMethod();
        //when
        List<String> resultList = reservationDAO.getReservation("11.15","13.15");
        //then
        assertNotNull(resultList);
    }

    @Test
    void testGetReservation()
    {
        //given
        Reservation reservation = new Reservation(1,"11.15","12.15");
        given(reservationDAO.bookReservation(reservation)).willReturn(reservation.getRoom_id());
        //when
        Integer id = reservationDAO.bookReservation(reservation);
        //then
        assertEquals(1,id);
    }

}