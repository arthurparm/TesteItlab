package pratico.java.senior.itlab.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nota_fiscal")
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty(localName = "clienteId")
    private String clienteId;

    @JacksonXmlProperty(localName = "dadosPagamento")
    private String dadosPagamento;

    @Version
    @JacksonXmlProperty(isAttribute = true)
    private Long version;
}

