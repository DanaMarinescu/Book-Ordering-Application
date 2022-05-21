package org.loose.fis.sre.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Book;

import java.io.IOException;

public class CartController {
    private Stage window;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Book,String> id_author;

    @FXML
    private TableColumn<Book,Float> id_price;

    @FXML
    private TableColumn<Book, String> id_title;

    @FXML
    private TableColumn<Book, Integer> id_year;

    @FXML
    void toBooks(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Books.fxml"));
        window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void toOrder(javafx.event.ActionEvent actionEvent) throws IOException{

    }

}
