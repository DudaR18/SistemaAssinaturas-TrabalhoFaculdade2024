package com.dudaenzo.tfinal.Dominio.InterfaceRepositorios;

import java.util.List;

import com.dudaenzo.tfinal.Dominio.Entidade.ClienteModel;

public interface IClienteRepositorio {
    List<ClienteModel> allClientes();

    ClienteModel consultaPorCodigo(long codigo);

    ClienteModel consultaPorNome(String nome);

    ClienteModel consultaPorEmail(String email);

    ClienteModel salvarCliente(ClienteModel cliente); // cria novo ou atualiza cliente

    void removerCliente(long codigo);
}