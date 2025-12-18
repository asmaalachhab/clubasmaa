package asmaa.client.ui;

import asmaa.client.model.User;
import asmaa.client.network.ClientSocket;
import asmaa.client.network.Request;
import asmaa.client.network.Response;
import asmaa.client.util.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuestController {

    @FXML
    private TextField txtName, txtPhone, txtEmail;

    @FXML
    private Button btnNext, btnBack;

    @FXML
    public void initialize() {
        ClientSocket socket = SessionManager.getInstance().getClientSocket();

        btnNext.setOnAction(e -> {
            try {
                User guest = new User();
                guest.setName(txtName.getText());
                guest.setEmail(txtEmail.getText());
                guest.setPhone(txtPhone.getText());

                Request req = new Request("GUEST", guest);
                Response resp = (Response) socket.sendRequest(req);

                if(resp.isSuccess()) {
                    SessionManager.getInstance().setCurrentUser((User) resp.getData());
                    // Passer à ChooseCity.fxml
                }
            } catch (Exception ex) { ex.printStackTrace(); }
        });

        btnBack.setOnAction(e -> ((Stage) btnBack.getScene().getWindow()).close());
    }
}
