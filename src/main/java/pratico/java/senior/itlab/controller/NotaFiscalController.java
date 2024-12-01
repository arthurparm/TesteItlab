package pratico.java.senior.itlab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pratico.java.senior.itlab.model.NotaFiscal;
import pratico.java.senior.itlab.service.NotaFiscalService;

@AllArgsConstructor
@RestController
public class NotaFiscalController {
    private NotaFiscalService notaFiscalService;

    @PostMapping("/notafiscal")
    public ResponseEntity<?> sendNotaFiscal(@RequestBody NotaFiscal notaFiscal) {
        try {
            NotaFiscal notaFiscal1 = notaFiscalService.processarNota(notaFiscal);
            return ResponseEntity.ok(notaFiscal1);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao enviar Nota Fiscal: " + e.getMessage());
        }
    }
}


