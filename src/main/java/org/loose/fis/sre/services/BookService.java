package org.loose.fis.sre.services;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.BookAlreadyExistsException;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.model.User;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class BookService {
    private static ObjectRepository<Book> bookRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("books.db").toFile())
                .openOrCreate("test", "test");

        bookRepository = database.getRepository(Book.class);
    }
    public static ObservableList getBooks(){
        ObservableList bookList= FXCollections.observableArrayList();
        bookList.removeAll();
        for (Book book:bookRepository.find()){
            bookList.add(book);
        }
        return bookList;
    }

    public static void addBook(String publishingHouse, String title, int year, String authorName)throws BookAlreadyExistsException{
        checkBookDoesNotAlreadyExist(title);
        bookRepository.insert(new Book(publishingHouse,title,year,authorName));
    }

    public static void checkBookDoesNotAlreadyExist(String title) throws BookAlreadyExistsException {
        for (Book book: bookRepository.find()){
            if(Objects.equals(title,book.getTitle())){
                throw new BookAlreadyExistsException(title);
            }
        }
    }
}
