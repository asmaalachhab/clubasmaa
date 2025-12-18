package asmaa.client.ui;

import asmaa.client.model.City;
import asmaa.client.util.SessionManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.List;

public class ChooseCityController {
    @FXML private ComboBox<City> cmbCities;
    @FXML private Button btnNext;

    @FXML
    public void initialize(){
        // Simuler liste de villes
        List<City> cities=List.of(
                new City(1,"Casablanca"),
                new City(2,"Fès"),
                new City(3,"Marrakech"),
                new City(4,"Agadir"),
                new City(5,"Tanger")
        );
        cmbCities.setItems(FXCollections.observableArrayList(cities));

        btnNext.setOnAction(e->{
            City selected=cmbCities.getSelectionModel().getSelectedItem();
            if(selected!=null){
                SessionManager.getInstance().setSelectedCity(selected);
                System.out.println("Ville choisie: "+selected.getName());
                // TODO: Naviguer vers ChooseClubController
            }
        });
    }
}
