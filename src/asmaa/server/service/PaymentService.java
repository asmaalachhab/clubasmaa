package asmaa.server.service;

import asmaa.server.dao.ReservationDAO;
import asmaa.server.model.Payment;
import asmaa.server.model.PaymentStatus;
import asmaa.server.model.Reservation;

import java.sql.Connection;

public class PaymentService {
    private ReservationDAO reservationDAO;

    public PaymentService(Connection conn) {
        this.reservationDAO = new ReservationDAO(conn);
    }

    public boolean processPayment(Reservation reservation) {
        Payment payment = reservation.getPayment();
        if(payment.getMethod().equalsIgnoreCase("CARD")) {
            payment.setStatus(PaymentStatus.PAYE);
        } else if(payment.getMethod().equalsIgnoreCase("CASH")) {
            payment.setStatus(PaymentStatus.EN_ATTENTE);
        } else {
            payment.setStatus(PaymentStatus.SUR_PLACE);
        }
        return reservationDAO.makeReservation(reservation);
    }
}
