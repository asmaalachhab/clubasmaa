package asmaa.client.ui;

import asmaa.client.model.Payment;
import asmaa.client.model.Reservation;
import asmaa.client.util.SessionManager;
import asmaa.client.service.ReservationServiceClient;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.time.LocalTime;
import java.util.List;

public class ChooseTimeSlotController {
    @FXML private ComboBox<LocalTime> cmbTimeSlots;
    @FXML private Button btnReserve;

    @FXML
    public void initialize(){
        List<LocalTime> slots=List.of(
                LocalTime.of(8,0),
                LocalTime.of(10,0),
                LocalTime.of(12,0),
                LocalTime.of(14,0),
                LocalTime.of(16,0)
        );
        cmbTimeSlots.setItems(FXCollections.observableArrayList(slots));

        btnReserve.setOnAction(e->{
            LocalTime selected=cmbTimeSlots.getSelectionModel().getSelectedItem();
            if(selected!=null){
                System.out.println("Créneau choisi: "+selected);

                Reservation res=new Reservation();
                res.setUser(SessionManager.getInstance().getCurrentUser());
                res.setTerrain(SessionManager.getInstance().getSelectedTerrain());
                res.setDate(SessionManager.getInstance().getSelectedDate());
                res.setTimeSlot(selected);

                Payment payment=new Payment();
                payment.setAmount(SessionManager.getInstance().getSelectedTerrain().getPrice());
                payment.setMethod("CARTE");
                res.setPayment(payment);

                boolean success=new ReservationServiceClient(SessionManager.getInstance().getClientSocket()).makeReservation(res);

                if(success) System.out.println("Réservation réussie !");
                else System.out.println("Ce créneau est déjà réservé !");
            }
        });
    }
}
