package asmaa.client.controller;

import asmaa.client.model.SportType;
import asmaa.client.model.Terrain;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.List;

public class TerrainsController {

    private SportType sportType; // sport reçu depuis HomeController

    @FXML
    private TilePane terrainsPane;

    @FXML
    private ComboBox<String> timeBox;

    @FXML
    private Label selectedTerrainLabel;

    private Terrain selectedTerrain;

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    @FXML
    public void initialize() {
        // Créneaux horaires
        timeBox.getItems().addAll(
                "08:00 - 09:00",
                "09:00 - 10:00",
                "10:00 - 11:00",
                "14:00 - 15:00",
                "16:00 - 17:00",
                "18:00 - 19:00"
        );

        // Liste des terrains
        List<Terrain> terrains = List.of(
                new Terrain("Terrain Foot 1", SportType.FOOTBALL, "/images/terrains/foot1.jpg"),
                new Terrain("Terrain Foot 2", SportType.FOOTBALL, "/images/terrains/foot2.jpg"),
                new Terrain("Terrain Basket", SportType.BASKETBALL, "/images/terrains/foot3.jpg"),
                new Terrain("Terrain Tennis", SportType.TENNIS, "/images/terrains/foot4.jpg"),
                new Terrain("Terrain Padel 1", SportType.PADEL, "/images/terrains/foot1.jpg"),
                new Terrain("Terrain Padel 2", SportType.PADEL, "/images/terrains/foot2.jpg")
        );

        // Filtrer par sport si défini
        if (sportType != null) {
            terrains = terrains.stream()
                    .filter(t -> t.getSport() == sportType)
                    .toList();
        }

        terrains.forEach(this::createTerrainCard);
    }

    private void createTerrainCard(Terrain terrain) {
        ImageView imageView = new ImageView(
                new Image(getClass().getResourceAsStream(terrain.getImagePath()))
        );
        imageView.setFitWidth(220);
        imageView.setFitHeight(140);
        imageView.setPreserveRatio(true);

        Label nameLabel = new Label(terrain.getNom() + " (" + terrain.getSport().name() + ")");
        nameLabel.getStyleClass().add("terrain-name");

        VBox card = new VBox(imageView, nameLabel);
        card.getStyleClass().add("terrain-card");

        card.setOnMouseClicked(e -> {
            selectedTerrain = terrain;
            selectedTerrainLabel.setText(
                    "Terrain sélectionné : " +
                            terrain.getNom() +
                            " - " +
                            terrain.getSport().name()
            );
        });

        terrainsPane.getChildren().add(card);
    }

    @FXML
    private void reserve() {
        if (selectedTerrain == null || timeBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner un terrain et un créneau.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Réservation confirmée");
        alert.setHeaderText(null);
        alert.setContentText(
                "Sport : " + selectedTerrain.getSport().name() +
                        "\nTerrain : " + selectedTerrain.getNom() +
                        "\nCréneau : " + timeBox.getValue()
        );
        alert.showAndWait();
    }
}
