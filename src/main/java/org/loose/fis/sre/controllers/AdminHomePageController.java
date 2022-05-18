package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHomePageController {
    @FXML
    private Button AvailableBooks;
    @FXML
    private Button CurrentOrders;
    @FXML
    private Button PastOrders;

    private Stage window;
    private Scene scene;

    @FXML
    public void viewAvailableBooks(javafx.event.ActionEvent actionEvent)throws IOException {
        scene=new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("booksAdmin.fxml")));
        window=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    @FXML
    public void viewCurrentOrders(){

    }
    @FXML
    public void viewPastOrders(){

    }
}
