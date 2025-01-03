package com.example.RabbitMQ_example.consumer;

import com.example.RabbitMQ_example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class TestUserConsumer {

    private UserConsumer userConsumer;

    @BeforeEach
    void setUp() {
        userConsumer = new UserConsumer();
    }

    @Test
    void testReceiveValidUser() {
        User validUser = new User("1", "Vikram", "vikram@gmail.com");

        assertDoesNotThrow(()
                -> userConsumer.receiveUser(validUser), "Should process valid User without exceptions");
    }

    @Test
    void testReceiveNullUser() {

        assertDoesNotThrow(()
                -> userConsumer.receiveUser(null), "handles nulls");
    }

    @Test
    void testReceiveMalformedUser() {

        User malformedUser = new User("2", "vikram", null);

        assertDoesNotThrow(() -> userConsumer.receiveUser(malformedUser), "mail is missing");
    }
}
