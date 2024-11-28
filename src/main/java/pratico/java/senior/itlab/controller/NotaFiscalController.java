package pratico.java.senior.itlab.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pratico.java.senior.itlab.model.NotaFiscal;
import pratico.java.senior.itlab.service.NotaFiscalService;

@RestController
@AllArgsConstructor
@RequestMapping("/notas")
public class NotaFiscalController {
    private NotaFiscalService service;

    @PostMapping
    public ResponseEntity<NotaFiscal> receberNota(@RequestBody NotaFiscal nota) {
        NotaFiscal savedNota = service.processarNota(nota);
        return ResponseEntity.ok(savedNota);
    }
}

