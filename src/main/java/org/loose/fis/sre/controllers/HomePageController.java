package org.loose.fis.sre.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;


public class HomePageController{
    @FXML
    private Button Orders;
    @FXML
    private Button PublishingHouses;
    @FXML
    private Button toLogin;

    private Stage window;
    private Scene scene;
    private Parent root;
        @FXML
        public void Orders(ActionEvent event)throws IOException {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("PastOrders.fxml")); //Orders page
            window= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            window.setScene(scene);
            window.show();
        }

        @FXML
        public void PublishingHouses(ActionEvent event) throws IOException {
            scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("PublishingHouses.fxml")));
            window= (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }

    @FXML
    void toLogin(ActionEvent event) throws  IOException{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml")); //login page
        window= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    }


