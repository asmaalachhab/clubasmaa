package asmaa.client.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Serializable {
    private User user;
    private Terrain terrain;
    private LocalDate date;
    private LocalTime timeSlot;
    private Payment payment;

    public Reservation() {}

    public User getUser(){ return user; }
    public void setUser(User user){ this.user=user; }
    public Terrain getTerrain(){ return terrain; }
    public void setTerrain(Terrain terrain){ this.terrain=terrain; }
    public LocalDate getDate(){ return date; }
    public void setDate(LocalDate date){ this.date=date; }
    public LocalTime getTimeSlot(){ return timeSlot; }
    public void setTimeSlot(LocalTime timeSlot){ this.timeSlot=timeSlot; }
    public Payment getPayment(){ return payment; }
    public void setPayment(Payment payment){ this.payment=payment; }
}
