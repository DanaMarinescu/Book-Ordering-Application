package org.loose.fis.sre.controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.loose.fis.sre.model.ModelPH;
import org.loose.fis.sre.services.OrderService;
import org.loose.fis.sre.services.PublishingHousesService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PublishingHousesController implements Initializable  {
    @FXML
    private TableColumn<ModelPH, String> col_name;

    @FXML
    private TableView<ModelPH> table;

    private Stage window;
    private Scene scene;
    private Parent root;
    private static String selectat;

    @FXML
    void toHomePage(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HomePage.fxml"));
        window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }


    public void seeBooks(javafx.event.ActionEvent actionEvent) throws IOException {
       selectat=table.getSelectionModel().getSelectedItem().getName();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Books.fxml"));
        window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    public static String getSelectat(){
        return selectat;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       col_name.setCellValueFactory(new PropertyValueFactory<ModelPH, String>("name"));
       initializePublishingHouses();
       table.setItems(PublishingHousesService.getPublishingHouses());


    }

    public static void initializePublishingHouses(){
        ObservableList<ModelPH> pubHouses=PublishingHousesService.getPublishingHouses();
        for (ModelPH ph:pubHouses){
            if(OrderService.isClosed())
            OrderService.initDatabase(ph.getName());
        }
    }
}





