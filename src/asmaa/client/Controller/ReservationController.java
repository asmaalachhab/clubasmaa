package asmaa.client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReservationController {

    @FXML private ComboBox<String> cityBox;
    @FXML private ComboBox<String> timeBox;
    @FXML private Label priceLabel;
    @FXML private ChoiceBox<String> paymentBox;

    @FXML
    public void initialize() {
        cityBox.getItems().addAll("Casablanca", "Agadir", "Fès", "Tanger", "Marrakech");
        timeBox.getItems().addAll("08:00 - 09:00", "09:00 - 10:00", "18:00 - 19:00");

        timeBox.setOnAction(e -> priceLabel.setText("Prix : 200 DH"));
    }

    @FXML
    private void confirmReservation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Réservation confirmée");
        alert.setContentText("Un email de confirmation a été envoyé.");
        alert.showAndWait();
    }
}
