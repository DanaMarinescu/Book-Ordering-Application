package org.loose.fis.sre.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void getTitle() {
        Book b = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals("Title", b.getTitle());
    }

    @Test
    void getYear() {
        Book b = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals(2001, b.getYear());
    }

    @Test
    void getAuthorName() {
        Book b = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals("authorName", b.getAuthorName());
    }

    @Test
    void setTitle() {
        Book b = new Book();
        String s = "title";
        b.setTitle(s);
        Assertions.assertEquals(s, b.getTitle());
    }

    @Test
    void setYear() {
    }

    @Test
    void setAuthorName() {
        Book b = new Book();
        String s = "authorName";
        b.setAuthorName(s);
        Assertions.assertEquals(s, b.getAuthorName());
    }

    @Test
    void getPrice() {
        Book b = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals(23.34f, b.getPrice());
    }

    @Test
    void setPrice() {
        Book b = new Book();
        Float p = 23.34f;
        b.setPrice(p);
        Assertions.assertEquals(p, b.getPrice());
    }

    @Test
    void getStock() {
        Book b = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals(10, b.getStock());
    }

    @Test
    void setStock() {
        Book b = new Book();
        int st=10;
        b.setStock(st);
        Assertions.assertEquals(st, b.getPrice());
    }

    @Test
    void testEquals() {
        Book b1 = new Book();
        Book b2 = new Book();
        Assertions.assertEquals(true, b1.equals(b2));
    }

    @Test
    void testEquals2(){
        Book b1 = new Book("Title", 2001, 23.34f, "authorName", 10);
        Book b2 = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals(true, b1.equals(b2));
    }

    @Test
    void testHashCode() {
    }
}