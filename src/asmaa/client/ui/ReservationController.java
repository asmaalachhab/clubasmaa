package asmaa.client.ui;

import asmaa.client.model.Reservation;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.List;

public class ReservationController {

    @FXML private TableView<Reservation> reservationTable;

    public void setReservations(List<Reservation> reservations) {
        reservationTable.setItems(FXCollections.observableArrayList(reservations));
    }

    @FXML
    public void initialize() {
        // TODO: Configurer les colonnes de la table si nécessaire
    }
}
