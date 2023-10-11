package br.com.conta.sistema.casouso.imp;

import br.com.conta.sistema.casouso.porta.PortaTransferencia;
import br.com.conta.sistema.dominio.modelo.Conta;
import br.com.conta.sistema.dominio.servico.TransferenciaServico;
import br.com.conta.sistema.porta.ContaRepositorio;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import static br.com.conta.sistema.dominio.modelo.Erro.*;
import static java.util.Objects.isNull;

// Responsável por implementar a porta de operações para caso de uso de transferência.
// Sera gerenciado pelo IoC
@Named
public class PortaTransferenciaImp  implements PortaTransferencia {
    private ContaRepositorio repositorio;
    private TransferenciaServico transferenciaServico;

    // Ioc por construtor
    @Inject
    public PortaTransferenciaImp(ContaRepositorio repositorio, TransferenciaServico transferenciaServico) {
        this.repositorio = repositorio;
        this.transferenciaServico = transferenciaServico;
    }

    @Override
    public Conta getConta(Integer numero) {
        return repositorio.get(numero);
    }

    @Override
    @Transactional
    public void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valor) {
        //1. validação de parametros
        if (isNull(contaDebito)) {
            obrigatorio("Conta débito");
        }
        if (isNull(contaCredito)) {
            obrigatorio("Conta crédito");
        }
        if (isNull(valor)) {
            obrigatorio("Valor");
        }
        //2. validação de contas
        var debito = repositorio.get(contaDebito);
        if (isNull(debito)) {
            inexistente("Conta débito");
        }
        var credito = repositorio.get(contaCredito);
        if (isNull(credito)) {
            inexistente("Conta crédito");
        }
        //3.validacao mesma conta
        if (debito.getNumero().equals(credito.getNumero())) {
            mesmaConta();
        }
        //4. operação
        transferenciaServico.processar(valor, debito, credito);
        repositorio.alterar(debito);
        repositorio.alterar(credito);
    }
}
