package com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dudaenzo.tfinal.Interface.Repositorios.Entidades.Usuario;

public interface UsuarioJPA_ItRep extends CrudRepository<Usuario, long>{
    List<Usuario> findAll();
    List<Usuario> findByNomeContaining(String nome);
}