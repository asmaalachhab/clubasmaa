package asmaa.client.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class AdminController {

    @FXML private TableView usersTable;
    @FXML private TableView clubsTable;
    @FXML private TableView terrainsTable;
    @FXML private Button btnAddUser;
    @FXML private Button btnAddClub;
    @FXML private Button btnAddTerrain;
    @FXML private Button btnBlockTerrain;
    @FXML private Button btnPromotion;

    @FXML
    public void initialize() {
        // TODO: Initialisation des tables et boutons
        btnAddUser.setOnAction(e -> System.out.println("Ajouter un utilisateur"));
        btnAddClub.setOnAction(e -> System.out.println("Ajouter un club"));
        btnAddTerrain.setOnAction(e -> System.out.println("Ajouter un terrain"));
        btnBlockTerrain.setOnAction(e -> System.out.println("Bloquer terrain"));
        btnPromotion.setOnAction(e -> System.out.println("Ajouter promotion"));
    }
}
