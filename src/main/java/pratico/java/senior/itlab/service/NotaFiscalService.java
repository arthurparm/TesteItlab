package pratico.java.senior.itlab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pratico.java.senior.itlab.model.Boleto;
import pratico.java.senior.itlab.model.NotaFiscal;
import pratico.java.senior.itlab.repository.NotaFiscalRepository;
import pratico.java.senior.itlab.service.kafka.KafkaConsumerService;
import pratico.java.senior.itlab.service.kafka.KafkaProducerService;

@Service
@AllArgsConstructor
public class NotaFiscalService {
    private NotaFiscalRepository repository;
    private KafkaProducerService producer;
    private KafkaConsumerService consumer;

    public NotaFiscal processarNota(NotaFiscal nota) {
        producer.sendMessage(nota.getDadosPagamento());
        return repository.save(nota);
    }

    public Boleto lerBoletoNotaFiscal() {
        String numero = "";
        consumer.consume(numero);
        Boleto boleto = new Boleto();
        boleto.setNumeroBoleto(numero);
        return boleto;
    }
}
