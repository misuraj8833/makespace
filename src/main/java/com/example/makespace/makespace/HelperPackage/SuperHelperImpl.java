package com.example.makespace.makespace.HelperPackage;

import java.util.ArrayList;
import java.util.List;

public class SuperHelperImpl implements SuperHelper
{
    private String bookOrVacancy;
    private String startTime;
    private String endTime;
    private String noOfPersons;
    private BookingHelper bookingHelper = new BookingHelperImpl();
    private VacancyHelper vacancyHelper = new VacancyHelperImpl();
    private String savedRoomName = null;
    private List<String> returnedList = new ArrayList<>();

    public SuperHelperImpl(String bookOrVacancy, String startTime, String endTime, String noOfPersons) {
        this.bookOrVacancy = bookOrVacancy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfPersons = noOfPersons;
    }

    public SuperHelperImpl(String bookOrVacancy, String startTime, String endTime) {
        this.bookOrVacancy = bookOrVacancy;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public SuperHelperImpl() {
    }

    @Override
    public List<String> processInput() {
        if (bookOrVacancy.equalsIgnoreCase("book"))
        {
            //call the booking helper and pass the @startTime , @endTime , @noOfPersons
            // all through time and person classes
            savedRoomName = bookingHelper.driveBooking(startTime,endTime,noOfPersons);
            if(savedRoomName!=null)
            {
                returnedList.add(savedRoomName);
                return returnedList;

            }
            returnedList = null;
            return returnedList;
        }
        else if(bookOrVacancy.equalsIgnoreCase("vacancy"))
        {
            //call the vacancy helper and pass the @startTime , @endTime , all through time classes
            returnedList = vacancyHelper.driveVacancy(startTime,endTime);
            if(returnedList==null) {
                System.out.println("NO_VACANT_ROOM");
                System.exit(0);
            }
        }
        return returnedList;

    }

    @Override
    public List<String> returnedWordsProcessInput(String[] returnedWords)
    {
        List<String> returnedList = null;
        if (returnedWords.length==0 || returnedWords.length>4){
            System.out.println("There is no content or wrong content in the File");
        }
        else if (returnedWords.length == 3)
        {
            bookOrVacancy = returnedWords[0];
            startTime = returnedWords[1];
            endTime = returnedWords[2];
            SuperHelper superHelperVacancy = new SuperHelperImpl(bookOrVacancy, startTime, endTime);
            returnedList = processInput();
            if(returnedList!=null) {
                return returnedList;
            }
        }
        else if (returnedWords.length == 4)
        {
            bookOrVacancy = returnedWords[0];
            startTime = returnedWords[1];
            endTime = returnedWords[2];
            noOfPersons = returnedWords[3];
            SuperHelper superHelperBooking = new SuperHelperImpl(bookOrVacancy,startTime,endTime,noOfPersons);
            returnedList = processInput();
            if(returnedList!=null) {
                return returnedList;
            }

        }
        returnedList = null;
        return returnedList;
    }
}
