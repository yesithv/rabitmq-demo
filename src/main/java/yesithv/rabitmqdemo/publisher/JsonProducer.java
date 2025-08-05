package yesithv.rabitmqdemo.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import yesithv.rabitmqdemo.dto.User;

@Slf4j
@Service
public class JsonProducer {

    @Value("${rabbitmqdemo.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmqdemo.routingkey.json}")
    private String jsonRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public JsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user) {
        log.info("Sending Json message: {}", user.toString());
        rabbitTemplate.convertAndSend(exchangeName, jsonRoutingKey, user);
    }
}
