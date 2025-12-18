package asmaa.client.ui;

import asmaa.client.model.Terrain;
import asmaa.client.util.SessionManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.List;

public class ChooseTerrainController {
    @FXML private ComboBox<Terrain> cmbTerrains;
    @FXML private Button btnNext;

    @FXML
    public void initialize(){
        List<Terrain> terrains=List.of(
                new Terrain(1,"Terrain 1",SessionManager.getInstance().getSelectedSport(),100),
                new Terrain(2,"Terrain 2",SessionManager.getInstance().getSelectedSport(),120),
                new Terrain(3,"Terrain 3",SessionManager.getInstance().getSelectedSport(),80),
                new Terrain(4,"Terrain 4",SessionManager.getInstance().getSelectedSport(),90)
        );
        cmbTerrains.setItems(FXCollections.observableArrayList(terrains));

        btnNext.setOnAction(e->{
            Terrain selected=cmbTerrains.getSelectionModel().getSelectedItem();
            if(selected!=null){
                SessionManager.getInstance().setSelectedTerrain(selected);
                System.out.println("Terrain choisi: "+selected.getName());
                // TODO: Naviguer vers ChooseTimeSlotController
            }
        });
    }
}
