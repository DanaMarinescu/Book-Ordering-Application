package org.loose.fis.sre.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.services.OrderService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientOrdersController implements Initializable {
    private Stage window;
    private Scene scene;
    private Parent root;
    private static Book selectat;

        @FXML
        private TableColumn<Book, String> id_order;

        @FXML
        private TableColumn<Book, String> id_status;

        @FXML
        private TableView<Book> table;


    @FXML
        void seeDetails(javafx.event.ActionEvent actionEvent) throws IOException {
             selectat =table.getSelectionModel().getSelectedItem();

        }


        @FXML
        void toCart(javafx.event.ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Cart.fxml"));
            window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            window.setScene(scene);
            window.show();
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BookService.initDatabase(BooksController.getSelect().getTitle());
        OrderService.initDatabase((PublishingHousesController.getSelectat()));

        id_order.setCellValueFactory(new PropertyValueFactory<>("Order"));
        id_status.setCellValueFactory(new PropertyValueFactory<>("Status"));

        table.getItems().add(CartController.getSelectat());
    }
}


