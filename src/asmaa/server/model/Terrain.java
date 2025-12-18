package asmaa.server.model;

import java.io.Serializable;

public class Terrain implements Serializable {
    private int id;
    private String name;
    private String sport; // FOOTBALL, BASKETBALL, TENNIS, PADDLE
    private Club club;
    private double price;
    private boolean blocked;

    public Terrain() {}
    public Terrain(int id, String name, String sport, Club club, double price, boolean blocked) {
        this.id=id; this.name=name; this.sport=sport; this.club=club; this.price=price; this.blocked=blocked;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id=id; }
    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
    public String getSport() { return sport; }
    public void setSport(String sport) { this.sport=sport; }
    public Club getClub() { return club; }
    public void setClub(Club club) { this.club=club; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price=price; }
    public boolean isBlocked() { return blocked; }
    public void setBlocked(boolean blocked) { this.blocked=blocked; }
}
