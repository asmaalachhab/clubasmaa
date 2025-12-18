package asmaa.server.model;

import java.time.LocalDateTime;

public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(int id, String name, String email, String password, String phone,
                 String subscription, SubscriptionType subscriptionType, LocalDateTime registrationDate) {
        super(id, name, email, password, phone, subscription, subscriptionType, registrationDate);
    }

    // Méthodes spécifiques à l'admin
    public void blockUser(User user) {
        System.out.println("Utilisateur " + user.getName() + " bloqué.");
    }

    public void unblockUser(User user) {
        System.out.println("Utilisateur " + user.getName() + " débloqué.");
    }

    // D’autres méthodes admin pour gérer clubs, terrains, réservations, promotions...
}
