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

public class ClientOrdersController implements Initializable {
    private Stage window;
    private Scene scene;
    private Parent root;
    private static Order selectat;

        @FXML
        private TableColumn<Order, String> id_order;

        @FXML
        private TableColumn<Order, String> id_status;

        @FXML
        private TableView<Order> table;

        @FXML
        private TextField id_text;
        @FXML
        private TextField id_auth;
        @FXML
        private TextField id_s;
        @FXML
        private TextField id_p;


    @FXML
        void seeDetails() {
             selectat =table.getSelectionModel().getSelectedItem();
             String text = table.getSelectionModel().getSelectedItem().getBookTitle();
             String text1 = table.getSelectionModel().getSelectedItem().getAuthor();
             String text2 = table.getSelectionModel().getSelectedItem().getStatus();
             String text3 = Float.toString(table.getSelectionModel().getSelectedItem().getPrice());
             id_text.setText(text);
             id_auth.setText(text1);
             id_s.setText(text2);
             id_p.setText(text3);
        }


        @FXML
        void toHomePage(javafx.event.ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HomePage.fxml"));
            window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            window.setScene(scene);
            window.show();
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PublishingHousesController.initializePublishingHouses();
        id_order.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        id_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.setItems(OrderService.getClientOrders(LoginController.currentUser.getUsername()));
    }
}


