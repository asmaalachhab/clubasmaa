package asmaa.client.controller;

import asmaa.client.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {
        loginButton.setOnAction(e -> login());
    }

    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Vérification simple
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs");
            return;
        }

        // Après connexion, aller sur Home
        SceneManager.switchScene("/fxml/Home.fxml", "Home");
    }
}
