package asmaa.server.dao;

import asmaa.server.model.User;
import asmaa.server.model.SubscriptionType;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    // Login : retourne l'utilisateur si email + mot de passe corrects
    public User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Register : ajoute un utilisateur
    public boolean register(User user) {
        String sql = "INSERT INTO users(name,email,password,phone,subscription,subscription_type,registration_date) VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getSubscription());
            stmt.setString(6, user.getSubscriptionType().name());
            stmt.setTimestamp(7, Timestamp.valueOf(user.getRegistrationDate()));
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lister tous les utilisateurs
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Méthode privée pour mapper ResultSet → User
    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String phone = rs.getString("phone");
        String subscription = rs.getString("subscription");
        SubscriptionType subscriptionType = SubscriptionType.valueOf(rs.getString("subscription_type"));
        LocalDateTime registrationDate = rs.getTimestamp("registration_date").toLocalDateTime();

        return new User(id, name, email, password, phone, subscription, subscriptionType, registrationDate);
    }
}
