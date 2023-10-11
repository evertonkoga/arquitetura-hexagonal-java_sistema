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
    @Test
    @DisplayName("conta debito como obrigatório")
    void teste2() {
        try {
            transferenciaServico.processar(valorTransferencia, null, contaCredito);
            fail("conta debito obrigatório");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "Conta débito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }
    @Test
    @DisplayName("conta credito como obrigatório")
    void teste3() {
        try {
            transferenciaServico.processar(valorTransferencia, contaDebito, null);
            fail("conta credito obrigatório");
        } catch (NegocioException e) {
            assertEquals(e.getMessage(), "Conta crédito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }
}
