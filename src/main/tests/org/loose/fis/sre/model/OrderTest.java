package org.loose.fis.sre.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getBookTitle() {
        Order o=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Assertions.assertEquals("Title",o.getBookTitle());
    }

    @Test
    void setBookTitle() {
        Order o=new Order();
        o.setBookTitle("Title");
        Assertions.assertEquals("Title",o.getBookTitle());
    }

    @Test
    void getAuthor() {
        Order o=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Assertions.assertEquals("authorName",o.getAuthor());
    }

    @Test
    void setAuthor() {
        Order o=new Order();
        o.setAuthor("authorName");
        Assertions.assertEquals("authorName",o.getAuthor());
    }

    @Test
    void getYear() {
        Order o=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Assertions.assertEquals(2001,o.getYear());
    }

    @Test
    void setYear() {
        Order o=new Order();
        o.setYear(2001);
        Assertions.assertEquals(2001,o.getAuthor());
    }

    @Test
    void getPrice() {
        Order o=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Assertions.assertEquals(23.34f,o.getPrice());
    }

    @Test
    void setPrice() {
        Order o=new Order();
        o.setPrice(23.34f);
        Assertions.assertEquals(23.34f,o.getPrice());
    }

    @Test
    void getStatus() {
        Order o=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Assertions.assertEquals("Placed",o.getStatus());
    }

    @Test
    void setStatus() {
        Order o=new Order();
        o.setStatus("Placed");
        Assertions.assertEquals("Placed",o.getStatus());
    }

    @Test
    void getStock() {
        Order o=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Assertions.assertEquals(10,o.getStock());
    }

    @Test
    void setStock() {
        Order o=new Order();
        o.setStock(10);
        Assertions.assertEquals(10,o.getStock());
    }

    @Test
    void getUser() {
        Order o=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Assertions.assertEquals("username",o.getUser());
    }

    @Test
    void setUser() {
        Order o=new Order();
        o.setUser("username");
        Assertions.assertEquals("username",o.getUser());
    }
    @Test
    void testEquals() {
        Order o1=new Order();
        Order o2=new Order();
        Assertions.assertEquals(true, o1.equals(o2));
    }

    @Test
    void testEquals2(){
        Order o1=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Order o2=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Assertions.assertEquals(true, o1.equals(o2));
    }

    @Test
    void testHashCode() {
        Order o1=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Order o2=new Order("Title","authorName", 2001, 23.34f,"Placed", 10,"username");
        Assertions.assertTrue(o1.hashCode()==o2.hashCode());
    }
}