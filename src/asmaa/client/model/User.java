package asmaa.client.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String subscription;

    public User() {}

    public User(int id, String name, String email, String password, String phone, String subscription){
        this.id=id; this.name=name; this.email=email; this.password=password; this.phone=phone; this.subscription=subscription;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id=id; }
    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email=email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password=password; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone=phone; }
    public String getSubscription() { return subscription; }
    public void setSubscription(String subscription) { this.subscription=subscription; }
}
