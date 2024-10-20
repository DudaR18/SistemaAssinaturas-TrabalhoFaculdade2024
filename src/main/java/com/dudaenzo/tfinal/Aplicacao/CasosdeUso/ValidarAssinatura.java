package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IAssinaturaRepositorio;

import java.time.LocalDate;

public class ValidarAssinatura {
    private IAssinaturaRepositorio assinaturaRepositorio;

    public ValidarAssinatura(IAssinaturaRepositorio assinaturaRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
    }

    public boolean executar(Long codigoAssinatura) {
        AssinaturaModel assinatura = assinaturaRepositorio.findById(codigoAssinatura);
        if (assinatura == null) {
            throw new RuntimeException("Assinatura não encontrada!");
        }

        // Verifica se a assinatura ainda está válida
        return assinatura.getFimVigencia().isAfter(LocalDate.now());
    }
}