package asmaa.server.dao;

import asmaa.server.model.Payment;
import asmaa.server.util.DBConnection;

import java.sql.*;

public class PaymentDAO {

    public int addPayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payments (amount, status, method) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDouble(1, payment.getAmount());
            stmt.setString(2, payment.getStatus().name());
            stmt.setString(3, payment.getMethod());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }
}
