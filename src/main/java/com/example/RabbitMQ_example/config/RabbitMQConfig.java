package com.example.RabbitMQ_example.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE = "user-queue";
    public static final String EXCHANGE = "user-exchange";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true); // Durable queue
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }
}
