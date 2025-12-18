package asmaa.client.ui;


import asmaa.client.model.User;
import asmaa.client.network.ClientSocket;
import asmaa.client.util.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnLogin, btnBack;

    @FXML
    public void initialize(){
        ClientSocket socket=SessionManager.getInstance().getClientSocket();

        btnLogin.setOnAction(e->{
            try{
                User u=new User();
                u.setEmail(txtEmail.getText());
                u.setPassword(txtPassword.getText());
                Object resp=socket.sendRequest(u); // Ici remplacer par Request si tu as créé
                // Traitement réponse simulé
                SessionManager.getInstance().setCurrentUser(u);
                Alert a=new Alert(AlertType.INFORMATION,"Connexion OK");
                a.showAndWait();
            }catch(Exception ex){ ex.printStackTrace(); }
        });

        btnBack.setOnAction(e->((Stage)btnBack.getScene().getWindow()).close());
    }
}
