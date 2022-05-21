package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Book {
    @Id
    private String title;
    private int year;
    private float price;
    private String authorName;
    private int stock;



    public Book(){

    }

    public Book(String title, int year, float price, String authorName, int stock) {
        this.title = title;
        this.year = year;
        this.price = price;
        this.authorName = authorName;
        this.stock = stock;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Float.compare(book.price, price) == 0 && stock == book.stock && Objects.equals(title, book.title) && Objects.equals(authorName, book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, price, authorName, stock);
    }
}
