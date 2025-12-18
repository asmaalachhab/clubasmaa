package asmaa.client.model;

import java.io.Serializable;

public class Club implements Serializable {
    private int id;
    private String name;
    private City city;

    public Club() {}
    public Club(int id, String name, City city){ this.id=id; this.name=name; this.city=city; }

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }
    public City getCity(){ return city; }
    public void setCity(City city){ this.city=city; }
}
