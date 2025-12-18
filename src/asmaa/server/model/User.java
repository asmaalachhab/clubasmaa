package asmaa.server.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String subscription; // champ texte si DAO/Admin utilise getSubscription()
    private SubscriptionType subscriptionType;
    private LocalDateTime registrationDate;

    public User() {}

    // Constructeur complet avec tous les champs
    public User(int id, String name, String email, String password, String phone,
                String subscription, SubscriptionType subscriptionType, LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.subscription = subscription;
        this.subscriptionType = subscriptionType;
        this.registrationDate = registrationDate;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getSubscription() { return subscription; } // ajouté pour DAO/Admin
    public void setSubscription(String subscription) { this.subscription = subscription; }

    public SubscriptionType getSubscriptionType() { return subscriptionType; }
    public void setSubscriptionType(SubscriptionType subscriptionType) { this.subscriptionType = subscriptionType; }

    public LocalDateTime getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDateTime registrationDate) { this.registrationDate = registrationDate; }
}
