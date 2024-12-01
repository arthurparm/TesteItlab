package pratico.java.senior.itlab.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "boleto", groupId = "contas")
    public String consume(String message) {
        return message;
    }
}
