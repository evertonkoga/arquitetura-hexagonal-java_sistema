package teste;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "teste.unidade.dominio.modelo", // testando regras
        "teste.unidade.dominio.servico", // testando servicos
        "teste.casouso" // testando porta entrada (driver)
})
public class SuiteCore {
    // 100% da solução testada independente de front-end e serviços externos (banco de dados)
}
