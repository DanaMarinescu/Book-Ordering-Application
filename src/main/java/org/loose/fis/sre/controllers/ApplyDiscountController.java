package org.loose.fis.sre.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.model.Order;
import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.services.OrderService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ApplyDiscountController implements Initializable {
    @FXML
    private TableView<Order> pastOrders;
    @FXML
    private TableColumn<Order,String> bookTitle;
    @FXML
    private TableColumn<Order,String> year;
    @FXML
    private TableColumn<Order, String> price;
    @FXML
    private TableColumn<Order,String> authorName;
    @FXML
    private TableColumn<Order, String >status;
    @FXML
    private TableColumn<Order,String> username;
    @FXML
    private ChoiceBox amount;

    private Scene scene;
    private Stage window;

    public void initialize(URL url, ResourceBundle resourceBundle){
        amount.getItems().addAll("0","15","20","25");
        bookTitle.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        authorName.setCellValueFactory(new PropertyValueFactory<>("author"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        username.setCellValueFactory(new PropertyValueFactory<>("user"));
        pastOrders.setItems(OrderService.getClientOrders(CurrentOrdersController.getUser()));
    }

    @FXML
    public void applyDiscount(javafx.event.ActionEvent actionEvent)throws IOException{
        if(pastOrders.getSelectionModel().getSelectedItem().getStatus().equals("Accepted")){
            pastOrders.getSelectionModel().getSelectedItem().setPrice(pastOrders.getSelectionModel().getSelectedItem().getPrice()-Integer.parseInt(amount.getValue().toString()));
            deliverOrder();
            goBack(actionEvent);
        }
    }

    private void deliverOrder(){
        OrderService.editStatus(pastOrders.getSelectionModel().getSelectedItem(),"Delivered");
    }

    @FXML
    public void goBack(javafx.event.ActionEvent actionEvent) throws IOException {
        scene=new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("adminHomePage.fxml")));
        window=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
