package teste.unidade.dominio.servico;

import br.com.conta.sistema.dominio.modelo.Conta;
import br.com.conta.sistema.dominio.modelo.NegocioException;
import br.com.conta.sistema.dominio.servico.TransferenciaServico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Regra de Transferência")
public class TesteTransferenciaServico {
    BigDecimal valorSaldoConta = new BigDecimal(100);
    BigDecimal valorTransferencia = new BigDecimal(20);
    TransferenciaServico transferenciaServico = new TransferenciaServico();
    Conta contaDebito;
    Conta contaCredito;
    @BeforeEach
    void prepara() {
        contaDebito = new Conta(1, valorSaldoConta, "Fernando");
        contaCredito = new Conta(2, valorSaldoConta, "Rebeca");
        transferenciaServico = new TransferenciaServico();
    }

    @Test
    @DisplayName("valor nulo como obrigatório")
    void teste1() {
        try {
            transferenciaServico.processar(null, contaDebito, contaCredito);
            fail("valor transferência como obrigatório");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "Valor da transferência é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

}
