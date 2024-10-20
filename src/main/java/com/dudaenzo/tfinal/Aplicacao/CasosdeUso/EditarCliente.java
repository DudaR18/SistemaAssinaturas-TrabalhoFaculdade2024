package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.ClienteModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IClienteRepositorio;

public class EditarCliente {
    private IClienteRepositorio clienteRepositorio;

    public EditarCliente(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public ClienteModel executar(ClienteModel cliente) {
        if (clienteRepositorio.findById(cliente.getCodigo()) == null) {
            throw new RuntimeException("Cliente não encontrado!");
        }
        return clienteRepositorio.save(cliente);
    }
}