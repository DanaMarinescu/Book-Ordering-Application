package org.loose.fis.sre.tests;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.loose.fis.sre.model.Book;

public class BookTest {
    @Test
    public void getTitleTest() {
        Book b = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals("Title", b.getTitle());
    }

    @Test
    public void getAuthorNameTest() {
        Book b = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals("author", b.getAuthorName());
    }

    @Test
    public void getPriceTest() {
        Book b = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals(23.34f, b.getPrice());
    }


    @Test
    public void setTitleTest() {
        Book b = new Book();
        String s = "title";
        b.setTitle(s);
        Assertions.assertEquals(s, b.getTitle());
    }

    @Test
    public void setAuthorNameTest() {
        Book b = new Book();
        String s = "authorName";
        b.setAuthorName(s);
        Assertions.assertEquals(s, b.getAuthorName());
    }

    @Test
    public void setPriceTest() {
        Book b = new Book();
        Float p = 23.34f;
        b.setPrice(p);
        Assertions.assertEquals(p, b.getPrice());
    }

    @Test
    public void equalsTest1() {
        Book b1 = new Book();
        Book b2 = new Book();
        Assertions.assertEquals(true, b1.equals(b2));
    }

    @Test
    public void equalsTest2() {
        Book b1 = new Book("Title", 2001, 23.34f, "authorName", 10);
        Book b2 = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals(false, b1.equals(b2));
    }

    @Test
    public void hashCodeTest1() {
        Book b = new Book("Title", 2001, 23.34f, "authorName", 10);
        Assertions.assertEquals(-2042632799 ,b.hashCode());
    }

    @Test
    public void hashCodeTest2() {
        Book b = new Book();
        Assertions.assertEquals(0 ,b.hashCode());
    }
}