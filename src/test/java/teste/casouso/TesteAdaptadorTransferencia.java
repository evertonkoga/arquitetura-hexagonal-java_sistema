package teste.casouso;

import br.com.conta.sistema.casouso.porta.PortaTransferencia;
import br.com.conta.sistema.dominio.modelo.NegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Caso de Uso - Serviço de Transferência")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Build1.class)
public class TesteAdaptadorTransferencia {

    Integer contaInexistente = 30;

    @Inject
    PortaTransferencia porta;

    @Test
    @DisplayName("pesquisa conta com número nulo")
    void teste1() {
        try {
            var conta = porta.getConta(null);
            assertTrue(conta == null, "Conta deve ser nula");
        } catch (NegocioException e) {
            fail("Deva carregar uma conta nula.");
        }
    }
    @Test
    @DisplayName("pesquisa conta com número inexistente")
    void teste2() {
        try {
            var conta = porta.getConta(contaInexistente);
            assertTrue(conta == null, "Conta deve ser nula");
        } catch (NegocioException e) {
            fail("Deva carregar uma conta nula.");
        }
    }
}
