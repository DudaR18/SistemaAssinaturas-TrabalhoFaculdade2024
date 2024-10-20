package com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dudaenzo.tfinal.Interface.Repositorios.Entidades.Assinaturas;

public interface AssinaturaJPA_ItfRep extends CrudRepository<Assinaturas, long>{
    List<Assinaturas> findAll();
    Assinaturas findById(long codigo);
    void deleteById(long codigo)
    List<Assinaturas> findByNomeContaining(Aplicativo app);
    List<Assinaturas> findByNomeContaining(Cliente cliente);
    List<Assinaturas> findByNomeContaining(Date data); // inicio ou fim
}