package yesithv.rabitmqdemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yesithv.rabitmqdemo.dto.User;
import yesithv.rabitmqdemo.publisher.JsonProducer;
import yesithv.rabitmqdemo.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MessageController {

    private final RabbitMqProducer rabbitMqProducer;
    private final JsonProducer jsonProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMqProducer.sendMessage(message);
        return ResponseEntity.ok("Message Sent to RabbitMQ");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessageJson(@RequestBody User user) {
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json Message Sent to RabbitMQ");
    }

}


