package asmaa.server.model;

import java.io.Serializable;

public class Club implements Serializable {
    private int id;
    private String name;
    private City city;
    private String address;
    private String email;

    public Club() {}

    public Club(int id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Club(int id, String name, City city, String address, String email) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.email = email;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
