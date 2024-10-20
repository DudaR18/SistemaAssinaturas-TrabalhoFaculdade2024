package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IAssinaturaRepositorio;

import java.util.List;

public class ListarAssinaturasCliente {
    private IAssinaturaRepositorio assinaturaRepositorio;

    public ListarAssinaturasCliente(IAssinaturaRepositorio assinaturaRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public List<AssinaturaModel> executar(Long codigoCliente) {
        return assinaturaRepositorio.findByCliente(codigoCliente);
    }
}