package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.ClienteModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IClienteRepositorio;
import java.util.List;

public class ListarClientes {
    private IClienteRepositorio clienteRepositorio;

    public ListarClientes(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<ClienteModel> executar() {
        return clienteRepositorio.findAll();
    }
}