package asmaa.server.service;

import asmaa.server.dao.ReservationDAO;
import asmaa.server.model.Reservation;

import java.sql.Connection;

public class ReservationService {
    private static ReservationService instance;
    private ReservationDAO reservationDAO;

    private ReservationService(Connection conn) { reservationDAO = new ReservationDAO(conn); }

    public static void init(Connection conn) {
        if(instance==null) instance=new ReservationService(conn);
    }

    public static ReservationService getInstance() { return instance; }

    public boolean makeReservation(Reservation res) {
        synchronized(this) { return reservationDAO.makeReservation(res); }
    }
}
