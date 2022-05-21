package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UserDoesNotExistException;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.services.OrderService;
import org.loose.fis.sre.services.UserService;
import java.io.IOException;
public class LoginController {
    private Stage window;
    private Scene scene;

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

    public static User currentUser;

    @FXML

    public void handleLogInAction(javafx.event.ActionEvent actionEvent) throws IOException {
        try {
            if(UserService.checkUser(usernameField.getText(), passwordField.getText()).equals("Client")){
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("HomePage.fxml"));
            window=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            scene=new Scene(root);
            window.setScene(scene);
            window.show();}
            else{
                Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("adminHomePage.fxml"));
                window=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                scene=new Scene(root);
                window.setScene(scene);
                window.show();
                BookService.initDatabase(usernameField.getText());
                OrderService.initDatabase(usernameField.getText());
                OrderService.addOrder(usernameField.getText(),new Book("Iar123456789101112",253,589.58f,"Autor",26),"Placed");
            }

        } catch (UserDoesNotExistException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    @FXML

    public void goToRegister(javafx.event.ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            window= (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            window.setScene(scene);
            window.show();
    }

}
