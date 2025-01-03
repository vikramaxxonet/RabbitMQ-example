package com.example.RabbitMQ_example.producer;

import com.example.RabbitMQ_example.config.RabbitMQConfig;
import com.example.RabbitMQ_example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertNotNull;

 class UserProducerTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    private UserProducer userProducer;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        userProducer = new UserProducer(rabbitTemplate);
    }

    @Test
    void testSendUser() {

        User user = new User();
        user.setName("Vikram");
        user.setEmail("vikram@gmail.com");

        userProducer.sendUser(user);

        verify(rabbitTemplate).convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.QUEUE,
                user
        );
        assertNotNull(user.getId(), "User ID should be generated");
    }
}
