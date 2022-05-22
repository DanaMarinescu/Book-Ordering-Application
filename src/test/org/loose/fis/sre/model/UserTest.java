package org.loose.fis.sre.model;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUsernameTest() {
        User u = new User("username", "password", "role");
        Assertions.assertEquals("username", u.getUsername());
    }

    @Test
    void setUsernameTest() {
        User u = new User();
        String s = "username";
        u.setUsername(s);
        Assertions.assertEquals(s, u.getUsername());
    }

    @Test
    void getPasswordTest() {
        User u = new User("username", "password", "role");
        Assertions.assertEquals("password", u.getPassword());
    }


    @Test
    void getRoleTest() {
        User u = new User("username", "password", "role");
        Assertions.assertEquals("role", u.getRole());
    }

    @Test
    void setRoleTest() {
        User u = new User();
        String s = "role";
        u.setRole(s);
        Assertions.assertEquals(s, u.getRole());
    }

    @Test
    void testEqualsTestGol() {
        User u1 = new User();
        User u2 = new User();
        Assertions.assertEquals(true, u1.equals(u2));
    }

    @Test
    void testEqualsTest(){
        User u1 = new User("username", "password", "role");
        User u2 = new User("username1", "password1","role1");
        Assertions.assertEquals(false,u1.equals(u2));
    }

    @Test
    void testHashCodeTest() {
        User u1 = new User("username", "password", "role");
        User u2 = new User("username", "password","role");
        Assert.assertTrue(u1.equals(u2) && u2.equals(u1));
        Assert.assertTrue(u1.hashCode() == u2.hashCode());
    }
}