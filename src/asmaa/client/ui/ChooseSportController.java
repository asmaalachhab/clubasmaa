package asmaa.client.ui;

import asmaa.client.util.SessionManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.List;

public class ChooseSportController {
    @FXML private ComboBox<String> cmbSports;
    @FXML private Button btnNext;

    @FXML
    public void initialize(){
        List<String> sports=List.of("Football","Basketball","Tennis","Paddle");
        cmbSports.setItems(FXCollections.observableArrayList(sports));

        btnNext.setOnAction(e->{
            String selected=cmbSports.getSelectionModel().getSelectedItem();
            if(selected!=null){
                SessionManager.getInstance().setSelectedSport(selected);
                System.out.println("Sport choisi: "+selected);
                // TODO: Naviguer vers ChooseTerrainController
            }
        });
    }
}
