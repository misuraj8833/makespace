package com.example.makespace.makespace.DAO;

import com.example.makespace.makespace.Entity.Reservation;
import com.example.makespace.makespace.HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDAOImpl1 implements ReservationDAO
{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<String> getReservation(String startTime,String endTime) {

        Session session = sessionFactory.openSession();
        List<String> resultList ;
        Transaction transaction = null;
        try{
            //starting a transaction
            transaction =session.beginTransaction();
            //creating the query
            Query query = session.createSQLQuery("CALL getFreeMeetingRooms(:startTime,:endTime)");
            query.setParameter("startTime",startTime);
            query.setParameter("endTime",endTime);
            //firing the query
            resultList = query.getResultList();
            //commiting the transaction
            transaction.commit();
        }
        catch (NullPointerException nullPointerException)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
            throw new NullPointerException(nullPointerException.getMessage());
        }
        finally {
            session.close();
        }

        return resultList;
    }
    /*
    *
    * In here the @bookReservation() method will return the id back
    * need to match in getting and return the room name.
    *
    * */
    @Override
    public Integer bookReservation(Reservation reservation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            //starting a transaction
            transaction =session.beginTransaction();
            //creating the query
            //firing the query
            session.save(reservation);
            //commiting the transaction
            transaction.commit();
        }
        catch (NullPointerException nullPointerException)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
            throw new NullPointerException(nullPointerException.getMessage());
        }
        finally {
            session.close();
        }

        return reservation.getRoom_id();
    }

}
