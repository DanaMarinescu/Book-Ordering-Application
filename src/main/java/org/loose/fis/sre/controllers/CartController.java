package org.loose.fis.sre.controllers;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.model.Order;
import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.services.OrderService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    private Stage window;
    private Scene scene;
    private Parent root;
    private static Book selectat;

    @FXML
    private TableView<Book> table;

    @FXML
    private TableColumn<Book,String> id_author;

    @FXML
    private TableColumn<Book,Float> id_price;

    @FXML
    private TableColumn<Book, String> id_title;

    @FXML
    private TableColumn<Book, Integer> id_year;

    @FXML
    private TextField id_ms;

    @FXML
    void toBooks(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Books.fxml"));
        window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    @FXML
    void toOrder(){
        selectat=table.getSelectionModel().getSelectedItem();
        OrderService.addOrder(LoginController.currentUser.getUsername(),selectat,"Placed");
        id_ms.setText("PLACED!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        BookService.initDatabase(BooksController.getSelect().getTitle());
        OrderService.initDatabase((PublishingHousesController.getSelectat()));
        id_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        id_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        id_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        id_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));

        table.getItems().add(BooksController.getSelect());
    }
}
