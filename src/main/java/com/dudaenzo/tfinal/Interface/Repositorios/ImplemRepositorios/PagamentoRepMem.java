package com.dudaenzo.tfinal.Interface.Repositorios.ImplemRepositorios;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Repository;

import com.dudaenzo.tfinal.Dominio.Entidade.PagamentoModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IPagamentoRepositorio;

@Repository
public class PagamentoRepMem implements IPagamentoRepositorio {

    private List<PagamentoModel> pagamentos;

    public PagamentoRepMem() {
        pagamentos = new LinkedList<>();
        
        LocalDateTime pagamento1 = LocalDateTime.now();
        LocalDateTime pagamento2 = pagamento1.plusDays(30);
        LocalDateTime pagamento3 = pagamento2.plusDays(30); 

        pagamentos.add(new PagamentoModel(1000, 19.90, new Date(pagamento1), "PROMO10", 100));
        pagamentos.add(new PagamentoModel(2000, 34.90, new Date(pagamento2), "PROMO20", 200));
        pagamentos.add(new PagamentoModel(3000, 29.90, new Date(pagamento3), null, 300));
    }

    public List<PagamentoModel> allPagamentos() {
        return pagamentos;
    }

    public PagamentoModel buscarPorCodigo(long codigo) {
        return pagamentos.stream()
            .filter(pag -> pag.getCodigo() == codigo)
            .findFirst()
            .orElse(null);
    }

    public PagamentoModel salvarPagamento(PagamentoModel pagamento) {
        PagamentoModel pagamentoExistente = buscarPorCodigo(pagamento.getCodigo());
        if (pagamentoExistente != null) {
            pagamentos.remove(pagamentoExistente);
        }
        pagamentos.add(pagamento);
        return pagamento;
    }

    public void removerPagamento(long codigo) {
        pagamentos.removeIf(pag -> pag.getCodigo() == codigo);
    }
}
