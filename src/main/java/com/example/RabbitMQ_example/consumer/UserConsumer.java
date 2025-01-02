package com.example.RabbitMQ_example.consumer;

import com.example.RabbitMQ_example.config.RabbitMQConfig;
import com.example.RabbitMQ_example.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveUser(User user) {
        System.out.println("Received user: " + user);

    }
}
