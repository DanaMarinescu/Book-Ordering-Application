package org.loose.fis.sre.services;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectFilter;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.BookAlreadyExistsException;
import org.loose.fis.sre.model.Book;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class BookService {
    private static ObjectRepository<Book> bookRepository;

    public static void initDatabase(String publishingHouse) {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile(publishingHouse+".db").toFile())
                .openOrCreate("test", "test");

        bookRepository = database.getRepository(Book.class);
    }
    public static ObservableList<Book> getBooks(){
        ObservableList bookList= FXCollections.observableArrayList();
        bookList.removeAll();
        for (Book book:bookRepository.find()){
            bookList.add(book);
        }
        return bookList;
    }

    public static void addBook(String title, int year,float price, String authorName,int stock)throws BookAlreadyExistsException{
        checkBookDoesNotAlreadyExist(title);
        bookRepository.insert(new Book(title,year,price,authorName,stock));
    }

    public static void editBook(Book book, String title, int year, float price, String authorName,int stock){
        bookRepository.remove(book);
        bookRepository.insert(new Book(title,year,price,authorName,stock));
    }

    public static void clearDatabase(){
        for (Book book: bookRepository.find()){
            bookRepository.remove(book);
        }
    }

    public static int getLastIndex(){
       return getBooks().toArray().length;
    }

    public static void deleteBook(Book book){
        bookRepository.remove(book);
    }

    public static void checkBookDoesNotAlreadyExist(String title) throws BookAlreadyExistsException {
        for (Book book: bookRepository.find()){
            if(Objects.equals(title,book.getTitle())){
                throw new BookAlreadyExistsException(title);
            }
        }
    }
}
