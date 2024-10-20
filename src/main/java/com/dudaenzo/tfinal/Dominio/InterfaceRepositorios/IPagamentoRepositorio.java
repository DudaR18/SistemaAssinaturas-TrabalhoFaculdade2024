package com.dudaenzo.tfinal.Dominio.InterfaceRepositorios;

import java.util.List;

import com.dudaenzo.tfinal.Dominio.Entidade.PagamentoModel;

public interface IPagamentoRepositorio {
    List<PagamentoModel> allPagamentos();

    PagamentoModel buscarPorCodigo(long codigo);

    PagamentoModel salvarPagamento(PagamentoModel pagamento); // Salvar um novo pagamento

    void removerPagamento(long codigo);
}
