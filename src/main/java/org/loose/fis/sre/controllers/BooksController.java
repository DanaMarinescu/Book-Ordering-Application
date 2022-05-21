package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.BookAlreadyExistsException;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.services.BookService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BooksController implements Initializable {
    private Stage window;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Book> bTable;

    @FXML
    private TableColumn<Book, String> id_author;

    @FXML
    private Button id_cart;

    @FXML
    private TableColumn<Book, String> id_name;

    @FXML
    private TableColumn<Book, Float> id_price;

    @FXML
    private TableColumn<Book, Integer> id_year;

    @FXML
    void toCart(javafx.event.ActionEvent actionEvent) throws IOException {

    }

    @FXML
    void toPubHouses(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("PublishingHouses.fxml"));
        window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       BookService.initDatabase(PublishingHousesController.getSelectat());
        id_name.setCellValueFactory(new PropertyValueFactory<>("title"));
        id_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        id_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        id_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));

        bTable.setItems(BookService.getBooks());
    }
}
