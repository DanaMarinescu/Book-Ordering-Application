package org.loose.fis.sre.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsernameAlreadyExistsExceptionTest {

    @Test
    void getUsernameTest() {
        UsernameAlreadyExistsException u = new UsernameAlreadyExistsException("username");
        Assertions.assertEquals("username",u.getUsername());
    }
}