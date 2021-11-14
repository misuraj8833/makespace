package com.example.makespace.makespace.HelperPackage;

import com.example.makespace.makespace.DAO.ReservationDAO;
import com.example.makespace.makespace.DAO.ReservationDAOImpl1;
import com.example.makespace.makespace.printResult.ResultPrint;
import com.example.makespace.makespace.printResult.ResultPrintImpl;
import com.example.makespace.makespace.time.CheckTime;
import com.example.makespace.makespace.time.CheckTimeImpl;
import java.util.List;

public class VacancyHelperImpl implements VacancyHelper
{
    CheckTime checkTime = new CheckTimeImpl();
    ReservationDAO reservationDAO = new ReservationDAOImpl1();
    ResultPrint resultPrint = new ResultPrintImpl();

    @Override
    public List<String> driveVacancy(String startTime, String endTime) {
        List<String> resultList = null;
        boolean checkTimeResult;
        if(startTime.isEmpty()||endTime.isEmpty())
        {
            throw new RuntimeException("INCORRECT_INPUT");
        }
        else {
            checkTimeResult = checkTime.checkTime(startTime, endTime);

            if (!checkTimeResult) {
                resultPrint.setInput("INCORRECT_INPUT");
                resultPrint.printResult();
            }
            else if (checkTimeResult)
            {
                resultList = reservationDAO.getReservation(startTime,endTime);
            }
        }
        return resultList;
    }
}
