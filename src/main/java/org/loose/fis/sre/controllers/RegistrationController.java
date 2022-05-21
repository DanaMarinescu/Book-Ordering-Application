package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.PublishingHousesService;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class RegistrationController {
    private Stage window;
    private Scene scene;
    private Parent root;

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Admin");
    }

    @FXML
    public void handleRegisterAction(javafx.event.ActionEvent actionEvent) throws  IOException{
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            PublishingHousesService.addUser(usernameField.getText(),(String) role.getValue());
            registrationMessage.setText("Account created successfully!");
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            window= (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

}
