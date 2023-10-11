package teste.casouso;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// Responsável por configurar os serviços do spring
@Configuration
@ComponentScan({
        "br.com.conta.sistema", // objetos de sistema
        "br.com.conta.adaptador" // adptadores falsos
})
public class Build1 {
    // Build 1: Adaptador Testes -> Sistema <- Adptadores Mocks
}
