package org.loose.fis.sre.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelPHTest {

    @Test
    void getNameTest() {
        ModelPH m= new ModelPH("name","role");
        Assertions.assertEquals("name",m.getName());
    }

    @Test
    void setNameTest() {
        ModelPH m= new ModelPH();
        String s = "name";
        m.setName(s);
        Assertions.assertEquals(s, m.getName());
    }

    @Test
    void getRoleTest() {
        ModelPH m= new ModelPH("name","role");
        Assertions.assertEquals("role",m.getRole());
    }
}