package br.com.conta.adaptador;

import br.com.conta.sistema.dominio.modelo.Conta;
import br.com.conta.sistema.dominio.modelo.NegocioException;
import br.com.conta.sistema.porta.ContaRepositorio;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.isNull;

// Responsável por implementar a porta de saída (driven) de serviços de banco de dadosfalso.
// será gerenciado pelo IoC
@Named
public class AdaptadorContaFakeImp implements ContaRepositorio {
    private Map<Integer, Conta> banco = new HashMap<>();

    public AdaptadorContaFakeImp() {
        banco.put(10, new Conta(10, new BigDecimal(100), "Everton Fake"));
        banco.put(20, new Conta(20, new BigDecimal(100), "Koga Fake"));
    }

    public Conta get(Integer numero) {
        System.out.println("Fake banco de dados -> Conta get(numero)");
        return banco.get(numero);
    }
    public void alterar(Conta conta) {
        System.out.println("Fake banco de dados -> alterar(conta)");

        var ct = banco.get(conta.getNumero());
        if (isNull(ct)) {
            throw new NegocioException("Conta inexistente: " + conta.getNumero());
        }

        banco.put(conta.getNumero(), conta);
    }
}
