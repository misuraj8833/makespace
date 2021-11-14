package com.example.makespace.makespace.HelperPackage;

import com.example.makespace.makespace.DAO.ReservationDAO;
import com.example.makespace.makespace.DAO.ReservationDAOImpl1;
import com.example.makespace.makespace.Entity.Reservation;
import com.example.makespace.makespace.person.CheckPerson;
import com.example.makespace.makespace.person.CheckPersonImpl;
import com.example.makespace.makespace.printResult.ResultPrint;
import com.example.makespace.makespace.printResult.ResultPrintImpl;
import com.example.makespace.makespace.time.CheckTime;
import com.example.makespace.makespace.time.CheckTimeImpl;

import java.util.List;

public class BookingHelperImpl implements BookingHelper {

    CheckTime checkTime = new CheckTimeImpl();
    CheckPerson checkPerson = new CheckPersonImpl();
    ReservationDAO reservationDAO = new ReservationDAOImpl1();
    VacancyHelper vacancyHelper = new VacancyHelperImpl();
    ResultPrint resultPrint = new ResultPrintImpl();
    List<String> freeRooms ;
    String freeRoomName;
    String savedRoomName = null;
    Reservation reservation = null;
    int room_id=0;

    @Override
    public String driveBooking(String startTime, String endTime, String noOfPersons) {
        boolean checkTimeResult = checkTime.checkTime(startTime,endTime);
        int persons = Integer.parseInt(noOfPersons);
        boolean checkPersonResult = checkPerson.checkPerson(persons);
        if(!checkTimeResult)
        {
            resultPrint.setInput("INCORRECT_INPUT");
            resultPrint.printResult();
        }
        if(!checkPersonResult)
        {
            resultPrint.setInput("NO_VACANT_ROOM");
            resultPrint.printResult();
        }

        freeRooms = vacancyHelper.driveVacancy(startTime,endTime);
        freeRoomName = freeRoomCheck(freeRooms,noOfPersons);
        if(freeRooms==null||freeRoomName==null)
        {
            resultPrint.setInput("NO_VACANT_ROOM");
            resultPrint.printResult();
        }
            room_id = getRoomIDFromName(freeRoomName);
            reservation = new Reservation(room_id, startTime, endTime);
            try
            {
                int savedRoomId = reservationDAO.bookReservation(reservation);
                savedRoomName = getRoomName(savedRoomId);
            }
            catch (Exception e)
            {
                return null;
            }
            return savedRoomName;

    }

    private int getRoomId(String noOfPersons) {

        int persons = Integer.parseInt(noOfPersons);
        if(persons<=2)
            return 1;
        else if (persons>=3 && persons<=7)
            return 2;
        else if(persons>=7 && persons<=20)
            return 3;
        else
            return 0;
    }

    private String getRoomName(int roomId) {
        switch (roomId) {
            case 1:
                return "C-CAVE";
            case 2:
                return "D-TOWER";
            case 3:
                return "G-MANSION";
        }
        return null;
    }

    private int getRoomIDFromName(String roomName){
        switch (roomName) {
            case "C-CAVE":
                return 1;
            case "D-TOWER":
                return 2;
            case "G-MANSION":
                return 3;
        }
        return 0;
    }

    private String freeRoomCheck(List<String> freeRooms, String noOfPersons)
    {
        int room_id = getRoomId(noOfPersons);
        String roomName1 = getRoomName(room_id);

        if(freeRooms!=null) {
            if (freeRooms.size() > 1) {
                //check for the perfect match with the number of person
                //if not then return the next item from the list.
                if (freeRooms.contains(roomName1)) {
                    return roomName1;
                } else {
                    return freeRooms.get(1);
                }
            }
        }
            return null;
    }
}
