package pratico.java.senior.itlab.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pratico.java.senior.itlab.model.NotaFiscal;
import pratico.java.senior.itlab.repository.NotaFiscalRepository;

@Service
@AllArgsConstructor
public class NotaFiscalService {
    private NotaFiscalRepository repository;
    private KafkaTemplate<String, String> kafkaTemplate;

    public NotaFiscal processarNota(NotaFiscal nota) {
        kafkaTemplate.send("topico-boleto", nota.getDadosPagamento());
        return repository.save(nota);
    }
}
