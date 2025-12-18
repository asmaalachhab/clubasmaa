package asmaa.server.dao;

import asmaa.server.model.Terrain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TerrainDAO {
    private Connection conn;

    public TerrainDAO(Connection conn) { this.conn=conn; }

    public List<Terrain> getTerrainsByClubAndSport(int clubId, String sport) {
        List<Terrain> terrains = new ArrayList<>();
        try {
            String sql = "SELECT * FROM terrains WHERE club_id=? AND sport=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clubId);
            ps.setString(2, sport);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Terrain t = new Terrain();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setSport(rs.getString("sport"));
                t.setPrice(rs.getDouble("price"));
                t.setBlocked(rs.getBoolean("blocked"));
                terrains.add(t);
            }
        } catch(SQLException e){ e.printStackTrace(); }
        return terrains;
    }
}
