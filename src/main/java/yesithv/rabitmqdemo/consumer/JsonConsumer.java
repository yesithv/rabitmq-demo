package yesithv.rabitmqdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import yesithv.rabitmqdemo.dto.User;

@Slf4j
@Service
public class JsonConsumer {

    @RabbitListener(queues = {"${rabbitmqdemo.queue.json}"})
    public void consumeJsonMessage(User user) {
        log.info("Receiving Json message: {}", user.toString());
    }
}
