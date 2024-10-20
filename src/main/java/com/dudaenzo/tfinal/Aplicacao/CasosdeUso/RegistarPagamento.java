package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.PagamentoModel;
import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IAssinaturaRepositorio;
import com.dudaenzo.tfinal.Repositorios.Entidades.IPagamentoRepositorio;

import java.time.LocalDate;

public class RegistrarPagamento {
    private IPagamentoRepositorio pagamentoRepositorio;
    private IAssinaturaRepositorio assinaturaRepositorio;

    public RegistrarPagamento(IPagamentoRepositorio pagamentoRepositorio, IAssinaturaRepositorio assinaturaRepositorio) {
        this.pagamentoRepositorio = pagamentoRepositorio;
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public PagamentoModel executar(Long codigoAssinatura, double valorPago) {
        AssinaturaModel assinatura = assinaturaRepositorio.findById(codigoAssinatura);
        if (assinatura == null) {
            throw new RuntimeException("Assinatura não encontrada!");
        }

        // Verifica o valor pago e atualiza a data de validade
        if (valorPago == assinatura.getAplicativo().getCustoMensal()) {
            LocalDate novaDataValidade = assinatura.getFimVigencia().plusDays(30);
            assinatura.setFimVigencia(novaDataValidade);
            assinaturaRepositorio.save(assinatura);
        } else {
            throw new RuntimeException("Valor incorreto");
        }

        PagamentoModel pagamento = new PagamentoModel(codigoAssinatura, valorPago, LocalDate.now());
        return pagamentoRepositorio.save(pagamento);
    }
}