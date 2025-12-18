package asmaa.server.dao;

import asmaa.server.model.Club;
import asmaa.server.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClubDAO {
    private Connection conn;

    public ClubDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Club> getClubsByCity(City city) {
        List<Club> clubs = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT id, name FROM clubs WHERE city_id=?")) {
            stmt.setInt(1, city.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clubs.add(new Club(rs.getInt("id"), rs.getString("name"), city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clubs;
    }
}
