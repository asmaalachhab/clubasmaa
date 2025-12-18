package asmaa.client.util;
import asmaa.client.controller.TerrainsController;
import asmaa.client.model.SportType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private static Stage mainStage;

    // Définir le Stage principal depuis Main.java
    public static void setStage(Stage stage) {
        mainStage = stage;
    }

    // SwitchScene pour scènes avec SportType
    public static void switchScene(String fxml, String title, SportType sportType) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxml));
            Parent root = loader.load();

            TerrainsController controller = loader.getController();
            if (controller != null && sportType != null) {
                controller.setSportType(sportType);
            }

            mainStage.setTitle(title);
            mainStage.setScene(new Scene(root));
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SwitchScene pour scènes sans SportType (Login, Home, etc.)
    public static void switchScene(String fxml, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxml));
            Parent root = loader.load();

            mainStage.setTitle(title);
            mainStage.setScene(new Scene(root));
            mainStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
