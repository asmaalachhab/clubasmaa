package asmaa.server.service;

import asmaa.server.dao.ReservationDAO;

import java.sql.Connection;

public class StatsService {

    private ReservationDAO reservationDAO;

    public StatsService(Connection conn) {
        this.reservationDAO = new ReservationDAO(conn);
    }

    public double getOccupationRate(int terrainId) {
        // Retourne le taux d’occupation pour un terrain spécifique
        return reservationDAO.getOccupationRate(terrainId);
    }

    public double getTotalRevenue(int clubId) {
        // Retourne le revenu total simulé pour un club
        return reservationDAO.getTotalRevenue(clubId);
    }

    // Méthodes supplémentaires pour statistiques par ville, sport, etc.
    public double getOccupationRateByClub(int clubId) {
        // Simulé
        return 0.7;
    }

    public double getOccupationRateByCity(int cityId) {
        // Simulé
        return 0.65;
    }

    public double getRevenueByCity(int cityId) {
        return 5000.0; // simulé
    }
}
