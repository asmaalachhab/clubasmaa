package asmaa.client.util;

import asmaa.client.model.*;
import asmaa.client.network.ClientSocket;
import java.time.LocalDate;
import java.time.LocalTime;

public class SessionManager {
    private static SessionManager instance;
    private User currentUser;
    private City selectedCity;
    private Club selectedClub;
    private String selectedSport;
    private Terrain selectedTerrain;
    private LocalDate selectedDate;
    private LocalTime selectedTimeSlot;
    private ClientSocket clientSocket;

    private SessionManager(){}

    public static SessionManager getInstance(){
        if(instance==null) instance=new SessionManager();
        return instance;
    }

    // Getters & Setters
    public User getCurrentUser(){ return currentUser; }
    public void setCurrentUser(User u){ this.currentUser=u; }
    public City getSelectedCity(){ return selectedCity; }
    public void setSelectedCity(City c){ this.selectedCity=c; }
    public Club getSelectedClub(){ return selectedClub; }
    public void setSelectedClub(Club c){ this.selectedClub=c; }
    public String getSelectedSport(){ return selectedSport; }
    public void setSelectedSport(String s){ this.selectedSport=s; }
    public Terrain getSelectedTerrain(){ return selectedTerrain; }
    public void setSelectedTerrain(Terrain t){ this.selectedTerrain=t; }
    public LocalDate getSelectedDate(){ return selectedDate; }
    public void setSelectedDate(LocalDate d){ this.selectedDate=d; }
    public LocalTime getSelectedTimeSlot(){ return selectedTimeSlot; }
    public void setSelectedTimeSlot(LocalTime t){ this.selectedTimeSlot=t; }
    public ClientSocket getClientSocket(){ return clientSocket; }
    public void setClientSocket(ClientSocket s){ this.clientSocket=s; }
}
