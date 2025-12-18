package asmaa.client.ui;

import asmaa.client.model.Club;
import asmaa.client.util.SessionManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.List;

public class ChooseClubController {
    @FXML private ComboBox<Club> cmbClubs;
    @FXML private Button btnNext;

    @FXML
    public void initialize(){
        // Simuler clubs par ville
        List<Club> clubs=List.of(
                new Club(1,"Club A",SessionManager.getInstance().getSelectedCity()),
                new Club(2,"Club B",SessionManager.getInstance().getSelectedCity()),
                new Club(3,"Club C",SessionManager.getInstance().getSelectedCity()),
                new Club(4,"Club D",SessionManager.getInstance().getSelectedCity())
        );
        cmbClubs.setItems(FXCollections.observableArrayList(clubs));

        btnNext.setOnAction(e->{
            Club selected=cmbClubs.getSelectionModel().getSelectedItem();
            if(selected!=null){
                SessionManager.getInstance().setSelectedClub(selected);
                System.out.println("Club choisi: "+selected.getName());
                // TODO: Naviguer vers ChooseSportController
            }
        });
    }
}
