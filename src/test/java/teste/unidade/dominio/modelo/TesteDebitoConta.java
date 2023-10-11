package teste.unidade.dominio.modelo;

import br.com.conta.sistema.dominio.modelo.Conta;
import br.com.conta.sistema.dominio.modelo.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Regra de Débito de Conta")
public class TesteDebitoConta {
    BigDecimal cem = new BigDecimal(1000);
    Conta contaValida;

    @BeforeEach
    void prepara() {
        contaValida = new Conta(1, cem, "Fernando");
    }

    @Test
    @DisplayName("valor débito nulo como obrigatório")
    void teste1() {
        try {
            contaValida.debitar(null);
            fail("valor débito é obrigatório");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "Valor débito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }
}
