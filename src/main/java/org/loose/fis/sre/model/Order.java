package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Order {
    @Id
    private Book bookOrdered;
    private String status;

    public Order(){}

    public Order(Book bookOrdered, String status) {
        this.bookOrdered = bookOrdered;
        this.status = status;
    }

    public Book getBookOrdered() {
        return bookOrdered;
    }

    public void setBookOrdered(Book bookOrdered) {
        this.bookOrdered = bookOrdered;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(bookOrdered, order.bookOrdered) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookOrdered, status);
    }
}
