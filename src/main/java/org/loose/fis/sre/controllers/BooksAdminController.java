package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import org.loose.fis.sre.exceptions.BookAlreadyExistsException;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.services.BookService;
import javafx.scene.text.Text;

public class BooksAdminController{
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab editBook;
    @FXML
    private Tab addBook;
    @FXML
    private Tab deleteBook;
    @FXML
    private TextField publishingHouseName;
    @FXML
    private TextField bookTitle;
    @FXML
    private TextField year;
    @FXML
    private TextField authorName;
    @FXML
    private Text editMessage;
    @FXML
    private ListView<Book> booksList;



    @FXML
    public void handleTabs(){
        int index=tabPane.getSelectionModel().getSelectedIndex();
        if(index==0) editBook();
        else if(index==1) addBook();
        else deleteBook();
    }

    @FXML
    public void editBook(){
        BookService.editBook(publishingHouseName.getText(),bookTitle.getText(),Integer.parseInt(year.getText()),authorName.getText());
    }
    @FXML
    public void addBook(){
        try {
            BookService.addBook(publishingHouseName.getText(), bookTitle.getText(), Integer.parseInt(year.getText()), authorName.getText());
        }catch(BookAlreadyExistsException e){
            editMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void deleteBook(){

    }
}
