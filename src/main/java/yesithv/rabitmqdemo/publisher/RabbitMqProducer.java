package yesithv.rabitmqdemo.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMqProducer {

    @Value("${rabbitmqdemo.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmqdemo.routingkey.name}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        log.info("Sending Message: {}", message);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
