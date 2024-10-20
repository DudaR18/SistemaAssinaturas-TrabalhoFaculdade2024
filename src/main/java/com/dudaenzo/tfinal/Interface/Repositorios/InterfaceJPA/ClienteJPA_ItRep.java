package com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dudaenzo.tfinal.Interface.Repositorios.Entidades.Cliente;

public interface ClienteJPA_ItRep extends CrudRepository<Cliente, long>{
    List<Cliente> findAll();
    Cliente findById(long codigo);
    void deleteById(long codigo)
    List<Aplicativo> findByNomeContaining(String nomemail); // nome ou email
}