package pratico.java.senior.itlab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pratico.java.senior.itlab.model.Boleto;
import pratico.java.senior.itlab.service.NotaFiscalService;

@AllArgsConstructor
@RestController
public class BoletoController {
    private NotaFiscalService notaFiscalService;

    @GetMapping("/boleto")
    public ResponseEntity<?> sendNotaFiscal() {
        try {
            Boleto boleto = new Boleto();
            boleto = notaFiscalService.lerBoletoNotaFiscal();
            return ResponseEntity.ok(boleto);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao receber o boleto: " + e.getMessage());
        }
    }
}
