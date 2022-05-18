package org.loose.fis.sre.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.loose.fis.sre.exceptions.BookAlreadyExistsException;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.services.BookService;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class BooksAdminController implements Initializable {
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab editBook;
    @FXML
    private Tab addBook;
    @FXML
    private Tab deleteBook;
    @FXML
    private TextField addPublishingHouseName;
    @FXML
    private TextField editPublishinghouseName;
    @FXML
    private TextField addBookTitle;
    @FXML
    private TextField editBookTitle;
    @FXML
    private TextField addYear;
    @FXML
    private TextField editYear;
    @FXML
    private TextField addPrice;
    @FXML
    private TextField editPrice;
    @FXML
    private TextField addAuthorName;
    @FXML
    private TextField editAuthorName;
    @FXML
    private Text editMessage;
    @FXML
    private TableView<Book> editTable;
    @FXML
    private TableView<Book> deleteTable;
    @FXML
    private TableColumn<Book,String> publishingHouse;
    @FXML
    private TableColumn<Book,String> bookTitle;
    @FXML
    private TableColumn<Book,String> year;
    @FXML
    private TableColumn<Book, String> price;
    @FXML
    private TableColumn<Book,String> authorName;
    @FXML
    private TableColumn<Book,String> deletePublishingHouse;
    @FXML
    private TableColumn<Book,String> deleteBookTitle;
    @FXML
    private TableColumn<Book,String> deleteYear;
    @FXML
    private TableColumn<Book, String> deletePrice;
    @FXML
    private TableColumn<Book,String> deleteAuthorName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        publishingHouse.setCellValueFactory(new PropertyValueFactory<>("publishingHouse"));
        bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        authorName.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        deletePublishingHouse.setCellValueFactory(new PropertyValueFactory<>("publishingHouse"));
        deleteBookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        deleteYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        deletePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        deleteAuthorName.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        editTable.setItems(BookService.getBooks());
        deleteTable.setItems(BookService.getBooks());
        editTable.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                editPublishinghouseName.setText(editTable.getSelectionModel().getSelectedItem().getPublishingHouse());
                editBookTitle.setText(editTable.getSelectionModel().getSelectedItem().getTitle());
                editYear.setText(Integer.toString(editTable.getSelectionModel().getSelectedItem().getYear()));
                editPrice.setText(Float.toString(editTable.getSelectionModel().getSelectedItem().getPrice()));
                editAuthorName.setText(editTable.getSelectionModel().getSelectedItem().getAuthorName());
            }
        });
    }



    @FXML
    public void editBook(){
        if(editPublishinghouseName.getText()!=null && editBookTitle.getText()!=null && Integer.parseInt(editYear.getText())!=0 &&editAuthorName.getText()!=null){
            BookService.editBook(editTable.getSelectionModel().getSelectedItem(),editPublishinghouseName.getText(),editBookTitle.getText(),Integer.parseInt(editYear.getText()),Float.valueOf(editPrice.getText()),editAuthorName.getText());
            editTable.setItems(BookService.getBooks());
            deleteTable.setItems(BookService.getBooks());
        }
        else editMessage.setText("Nu ati introdus toate datele cartii!");
    }
    @FXML
    public void addBook(){
        try {
            if(addPublishingHouseName.getText()!=null && addBookTitle.getText()!=null && Integer.parseInt(addYear.getText())!=0 &&addAuthorName.getText()!=null) {
                BookService.addBook(addPublishingHouseName.getText(), addBookTitle.getText(), Integer.parseInt(addYear.getText()), Float.valueOf(addPrice.getText()), addAuthorName.getText());
                editTable.setItems(BookService.getBooks());
                deleteTable.setItems(BookService.getBooks());
            }
            else editMessage.setText("Nu ati introdus toate datele cartii!");
        }catch(BookAlreadyExistsException e){
            editMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void deleteBook(){
        BookService.deleteBook(deleteTable.getSelectionModel().getSelectedItem());
        editTable.setItems(BookService.getBooks());
        deleteTable.setItems(BookService.getBooks());
    }
}
