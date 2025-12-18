package asmaa.client.controller;

import asmaa.client.model.SportType;
import asmaa.client.util.SceneManager;
import javafx.fxml.FXML;

public class HomeController {

    @FXML
    private void openFootball() {
        SceneManager.switchScene(
                "/fxml/Terrains.fxml",
                "Terrains Football",
                SportType.FOOTBALL
        );
    }

    @FXML
    private void openBasket() {
        SceneManager.switchScene(
                "/fxml/Terrains.fxml",
                "Terrains Basketball",
                SportType.BASKETBALL
        );
    }

    @FXML
    private void openTennis() {
        SceneManager.switchScene(
                "/fxml/Terrains.fxml",
                "Terrains Tennis",
                SportType.TENNIS
        );
    }

    @FXML
    private void openPadel() {
        SceneManager.switchScene(
                "/fxml/Terrains.fxml",
                "Terrains Padel",
                SportType.PADEL
        );
    }
}
