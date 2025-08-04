package yesithv.rabitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmqdemo.queue.name}")
    private String queueName;

    @Value("${rabbitmqdemo.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmqdemo.routingkey.name}")
    private String routingKey;

    // Spring bean for RabbitMq queue
    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }

    // Spring autoconfiguration will automatically configure these 3 beans:
    // ConnectionFactory
    // RabbitTemplate
    // RabbitAdmin
}
