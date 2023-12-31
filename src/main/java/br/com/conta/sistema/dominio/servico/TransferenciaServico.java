package br.com.conta.sistema.dominio.servico;

import br.com.conta.sistema.dominio.modelo.Conta;
import javax.inject.Named;
import java.math.BigDecimal;
import static br.com.conta.sistema.dominio.modelo.Erro.obrigatorio;
import static java.util.Objects.isNull;


// Responsável por representar a entidade transferência e suas regras.
// Será gerenciado pelo IoC
@Named
public class TransferenciaServico {
    public void processar(BigDecimal valor, Conta debito, Conta credito) {
        if (isNull(valor)) {
            obrigatorio("Valor da transferência");
        }
        if (isNull(debito)) {
            obrigatorio("Conta débito");
        }
        if (isNull(credito)) {
            obrigatorio("Conta crédito");
        }
        debito.debitar(valor);
        credito.creditar(valor);
    }
}
