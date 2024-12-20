package pratico.java.senior.itlab.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic boletoTopic() {
        return new NewTopic("boleto", 1, (short) 1);
    }

}
