package com.dudaenzo.tfinal.Dominio.InterfaceRepositorios;

import java.util.List;

import com.dudaenzo.tfinal.Dominio.Entidade.PagamentoModel;

public interface IUsuarioRepositorio {
    UsuarioModel buscarPorUsuario (String usuario);

    UsuarioModel salvarUsuario(UsuarioModel usuario); // Salvar um novo usuário
}
