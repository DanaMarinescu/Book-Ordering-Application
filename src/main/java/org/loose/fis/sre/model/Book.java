package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Book {
    @Id
    private String publishingHouse;
    private String title;
    private int year;
    private String authorName;


    public Book(String publishingHouse, String title, int year, String authorName) {
        this.publishingHouse = publishingHouse;
        this.title = title;
        this.year = year;
        this.authorName = authorName;
    }

    public Book(){

    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(publishingHouse, book.publishingHouse) && Objects.equals(title, book.title) && Objects.equals(authorName, book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishingHouse, title, year, authorName);
    }
}
