package asmaa.client.model;

public class Terrain {

    private int id;
    private String name;
    private SportType sportType;
    private int price;
    private String imagePath;

    public Terrain(int id, String name, String imagePath, int price) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
    }

    public Terrain(int id, String name, SportType sportType, String imagePath, int price) {
        this.id = id;
        this.name = name;
        this.sportType = sportType;
        this.imagePath = imagePath;
        this.price = price;
    }

    // ✅ CONSTRUCTEUR MANQUANT (IMPORTANT)
    public Terrain(String name, SportType sportType, String imagePath) {
        this.name = name;
        this.sportType = sportType;
        this.imagePath = imagePath;
    }

    // ================= GETTERS =================

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // compatibilité UI
    public String getNom() {
        return name;
    }

    public SportType getSportType() {
        return sportType;
    }

    // compatibilité UI
    public SportType getSport() {
        return sportType;
    }

    public int getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return name + " (" + sportType + ")";
    }
}
