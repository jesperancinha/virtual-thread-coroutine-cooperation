package org.jesperancinha.vtcc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JVTJavaStructuredConcurrencyTest {

    private UserServiceJVTJava userServiceJava = new UserServiceJVTJava();

    @Test
    public void testJavaConcurrency() {
        userServiceJava.loadUserData(1000L);
        assertThat(userServiceJava.getAllUsers()).hasSize(1);
    }
}
