package com.dudaenzo.tfinal.Interface.Repositorios.ImplemRepositorios;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.dudaenzo.tfinal.Dominio.Entidade.PagamentoModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IPagamentoRepositorio;
import com.dudaenzo.tfinal.Interface.Repositorios.Entidade.Pagamento;
import com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA.PagamentoJPA_ItRep;

@Repository
@Primary
public class PagamentoRepJPA implements IPagamentoRepositorio {

    private final PagamentoJPA_ItRep pagamentoJPA;

    public PagamentoRepJPA(PagamentoJPA_ItRep pagamentoJPA) {
        this.pagamentoJPA = pagamentoJPA;
    }

    public List<PagamentoModel> allPagamentos() {
        List<Pagamento> pagamentos = pagamentoJPA.findAll();
        return pagamentos.stream().map(Pagamento::toPagamentoModel).toList();
    }

    public PagamentoModel buscarPorCodigo(long codigo) {
        return pagamentoJPA.findById(codigo).map(Pagamento::toPagamentoModel).orElse(null);
    }

    public PagamentoModel salvarPagamento(PagamentoModel pagamento) {

        double valorEstorno = pagamento.processarPagamento();  // Processar o pagamento e atualizar a assinatura
        pagamentos.add(pagamento);
        
        if (valorEstorno > 0) {
            System.out.println("Valor a ser estornado: " + valorEstorno);
        } else {
            System.out.println("Pagamento processado com sucesso! Nova validade: " + pagamento.getAssinatura().getValidade());
        }

        return pagamento;
    }

    public void removerPagamento(long codigo) {
        pagamentoJPA.deleteById(codigo);
    }
}
