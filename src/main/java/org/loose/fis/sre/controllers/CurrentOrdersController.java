package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.model.Order;
import org.loose.fis.sre.services.OrderService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CurrentOrdersController implements Initializable {
    @FXML
    private TableView<Order> currentOrders;
    @FXML
    private TableColumn<Book,String> bookTitle;
    @FXML
    private TableColumn<Book,String> authorName;
    @FXML
    private TableColumn<Book,String> year;
    @FXML
    private TableColumn<Book, String> price;
    @FXML
    private TableColumn<Order,String> status;

    private Scene scene;
    private Stage window;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        bookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        authorName.setCellValueFactory(new PropertyValueFactory<>("author"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        currentOrders.setItems(OrderService.getCurrentOrders());
    }

    public void acceptOrder(){
        OrderService.editStatus(currentOrders.getSelectionModel().getSelectedItem(),"Accepted");
        currentOrders.setItems(OrderService.getCurrentOrders());
    }

    public void rejectOrder(){
        OrderService.editStatus(currentOrders.getSelectionModel().getSelectedItem(),"Rejected");
        currentOrders.setItems(OrderService.getCurrentOrders());
    }

    public void goBack(javafx.event.ActionEvent actionEvent) throws IOException {
        scene=new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("adminHomePage.fxml")));
        window=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
