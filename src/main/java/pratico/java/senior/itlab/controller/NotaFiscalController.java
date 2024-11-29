package pratico.java.senior.itlab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pratico.java.senior.itlab.model.NotaFiscal;

@AllArgsConstructor
@RestController
public class NotaFiscalController {
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "nota_fiscal_topic";

    @PostMapping("/notafiscal")
    public ResponseEntity<String> sendNotaFiscal(@RequestBody NotaFiscal notaFiscal) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(notaFiscal);
            kafkaTemplate.send(TOPIC, xml);
            return ResponseEntity.ok("Nota Fiscal enviada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao enviar Nota Fiscal: " + e.getMessage());
        }
    }
}


