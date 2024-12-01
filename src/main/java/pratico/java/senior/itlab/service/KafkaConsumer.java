package pratico.java.senior.itlab.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "nota_fiscal_topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}