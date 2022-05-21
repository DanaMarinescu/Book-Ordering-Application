package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Order {

    @Id
    private String bookTitle;
    private String author;
    private int year;
    private float price;
    private String status;
    private int stock;

    public Order(){}

    public Order(String bookTitle, String author, int year, float price, String status,int stock) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.year = year;
        this.price = price;
        this.status = status;
        this.stock=stock;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        Order order = (Order) o;
        return year == order.year && Float.compare(order.price, price) == 0 && stock == order.stock && Objects.equals(bookTitle, order.bookTitle) && Objects.equals(author, order.author) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookTitle, author, year, price, status, stock);
    }
}
