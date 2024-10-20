package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.AplicativoModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IAplicativoRepositorio;

public class CadastrarAplicativo {
    private IAplicativoRepositorio aplicativoRepositorio;

    public CadastrarAplicativo(IAplicativoRepositorio aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public AplicativoModel executar(AplicativoModel aplicativo) {
        return aplicativoRepositorio.save(aplicativo);
    }
}