package asmaa.client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class GuestReservationController {

    @FXML
    private void confirm() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Réservation invitée confirmée !");
        alert.showAndWait();
    }
}
