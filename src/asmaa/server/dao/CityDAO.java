package asmaa.server.dao;

import asmaa.server.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    private Connection conn;

    public CityDAO(Connection conn) {
        this.conn = conn;
    }

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name FROM cities")) {
            while (rs.next()) {
                cities.add(new City(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
