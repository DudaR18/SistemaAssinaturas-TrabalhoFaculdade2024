package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IAssinaturaRepositorio;

public class EditarAssinatura {
    private IAssinaturaRepositorio assinaturaRepositorio;

    public EditarAssinatura(IAssinaturaRepositorio assinaturaRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public AssinaturaModel executar(AssinaturaModel assinatura) {
        if (assinaturaRepositorio.findById(assinatura.getCodigo()) == null) {
            throw new RuntimeException("Assinatura não encontrada!");
        }
        return assinaturaRepositorio.save(assinatura);
    }
}