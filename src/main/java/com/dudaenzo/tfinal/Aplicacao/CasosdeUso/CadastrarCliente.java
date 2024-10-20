package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.ClienteModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IClienteRepositorio;

public class CadastrarCliente {
    private IClienteRepositorio clienteRepositorio;

    public CadastrarCliente(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public ClienteModel executar(ClienteModel cliente) {
        return clienteRepositorio.save(cliente);
    }
}