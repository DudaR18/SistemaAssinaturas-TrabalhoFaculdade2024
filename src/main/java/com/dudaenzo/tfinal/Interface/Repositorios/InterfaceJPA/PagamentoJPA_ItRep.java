package com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dudaenzo.tfinal.Interface.Repositorios.Entidades.Pagamento;

public interface PagamentoJPA_ItfRep extends CrudRepository<Pagamento, long>{
    List<Pagamento> findAll();
    Pagamento findById(long codigo);
    void deleteById(long codigo)
    List<Pagamento> findByNomeContaining(double valorpago);
    List<Pagamento> findByNomeContaining(Assinaturas assinatura);
    List<Pagamento> findByNomeContaining(Date datapagamento); 
    List<Pagamento> findByNomeContaining(String promocao); 
}