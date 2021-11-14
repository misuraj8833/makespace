package com.example.makespace.makespace.HelperPackage;

import com.example.makespace.makespace.DAO.ReservationDAOImpl1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class VacancyHelperImplTest {

    @Mock
    ReservationDAOImpl1 reservationDAOImpl1;

    @InjectMocks
    VacancyHelperImpl vacancyHelperImpl;

    @Test
    void driveVacancy() {

        //given
        List<String> resultList = new ArrayList<>();
//        resultList.add("C-CAVE");
//        resultList.add("D-Tower");
//        resultList.add("G-Mansion");
        given(reservationDAOImpl1.getReservation("14:00","17:00")).willReturn(null);
        //when
        List<String> returnedList = vacancyHelperImpl.driveVacancy("14:00","17:00");
        //then
        assertNull(returnedList);
    }
}