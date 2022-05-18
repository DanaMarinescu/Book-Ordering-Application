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
       col_name.setCellValueFactory(new PropertyValueFactory<ModelPH, String>("name"));

       table.setItems(PublishingHousesService.getPublishingHouses());
    }
}





