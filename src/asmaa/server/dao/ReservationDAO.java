package asmaa.server.dao;

import asmaa.server.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private Connection conn;

    public ReservationDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean makeReservation(Reservation reservation) {
        String sql = "INSERT INTO reservations(user_id, terrain_id, date, time_slot, payment_status) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservation.getUser().getId());
            stmt.setInt(2, reservation.getTerrain().getId());
            stmt.setDate(3, Date.valueOf(reservation.getDate()));
            stmt.setString(4, reservation.getTimeSlot().toString());
            stmt.setString(5, reservation.getPayment().getStatus().name());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public double getOccupationRate(int terrainId) {
        return 0.75; // simulation
    }

    public double getTotalRevenue(int clubId) {
        return 1234.0; // simulation
    }

    public List<Reservation> getReservationsByUser(int userId) {
        return new ArrayList<>();
    }
}
