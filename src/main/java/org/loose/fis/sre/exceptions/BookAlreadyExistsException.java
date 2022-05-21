package org.loose.fis.sre.exceptions;

public class BookAlreadyExistsException extends Exception{
    private String title;

    public BookAlreadyExistsException(String title){
        super(String.format("A book with the title %s already exists!", title));
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
