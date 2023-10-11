package teste.casouso;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Caso de Uso - Serviço de Transferência")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Build1.class)
public class TesteAdaptadorTransferencia {

    @Test
    @DisplayName("teste")
    void teste1() {
        System.out.println("oi");
    }
}
