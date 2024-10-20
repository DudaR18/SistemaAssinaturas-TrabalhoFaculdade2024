package com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dudaenzo.tfinal.Interface.Repositorios.Entidades.Aplicativo;

public interface AplicativoJPA_ItfRep extends CrudRepository<Aplicativo, long>{
    List<Aplicativo> findAll();
    Aplicativo findById(long codigo);
    void deleteById(long codigo)
    List<Aplicativo> findByNomeContaining(String nome);
}