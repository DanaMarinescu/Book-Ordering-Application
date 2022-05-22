package org.loose.fis.sre.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDoesNotExistExceptionTest {

    @Test
    void getUsernameTest() {
        UserDoesNotExistException u = new UserDoesNotExistException("username");
        Assertions.assertEquals("username",u.getUsername());
    }
}