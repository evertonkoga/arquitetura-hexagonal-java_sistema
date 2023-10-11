package br.com.conta.adaptador;

import br.com.conta.sistema.dominio.modelo.Conta;
import br.com.conta.sistema.dominio.modelo.NegocioException;
import br.com.conta.sistema.porta.ContaRepositorio;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.isNull;


// Responsável por implementar a porta de saída (driven) de serviços de banco de dados falso.
// será gerenciado pelo IoC
@Named
public class AdaptadorContaFakeImp implements ContaRepositorio {
    private Map<Integer, Conta> banco = new HashMap<>();

    public AdaptadorContaFakeImp() {
        banco.put(10, new Conta(10, new BigDecimal(100), "Everton Fake"));
        banco.put(20, new Conta(20, new BigDecimal(100), "Koga Fake"));
    }
    @Override
    public Conta get(Integer numero) {
        return null;
    }

    @Override
    public void alterar(Conta conta) {

    }
}
