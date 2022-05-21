package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.model.Order;
import org.loose.fis.sre.services.OrderService;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        bookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        authorName.setCellValueFactory(new PropertyValueFactory<>("author"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        currentOrders.setItems(OrderService.getCurrentOrders(LoginController.currentUser.getUsername()));
    }

    public void acceptOrder(){
        OrderService.editStatus(currentOrders.getSelectionModel().getSelectedItem(),"Accepted");
        currentOrders.setItems(OrderService.getCurrentOrders(LoginController.currentUser.getUsername()));
    }

    public void rejectOrder(){
        OrderService.editStatus(currentOrders.getSelectionModel().getSelectedItem(),"Rejected");
        currentOrders.setItems(OrderService.getCurrentOrders(LoginController.currentUser.getUsername()));
    }
}
