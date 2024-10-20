package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.AplicativoModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IAplicativoRepositorio;

public class EditarAplicativo {
    private IAplicativoRepositorio aplicativoRepositorio;

    public EditarAplicativo(IAplicativoRepositorio aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public AplicativoModel executar(AplicativoModel aplicativo) {
        if (aplicativoRepositorio.findById(aplicativo.getCodigo()) == null) {
            throw new RuntimeException("Aplicativo não encontrado!");
        }
        return aplicativoRepositorio.save(aplicativo);
    }
}