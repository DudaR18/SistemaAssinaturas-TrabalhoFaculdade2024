package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.AplicativoModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IAplicativoRepositorio;

import java.util.List;

public class ListarAplicativos {
    private IAplicativoRepositorio aplicativoRepositorio;

    public ListarAplicativos(IAplicativoRepositorio aplicativoRepositorio) {
        this.aplicativoRepositorio = aplicativoRepositorio;
    }

    public List<AplicativoModel> executar() {
        return aplicativoRepositorio.findAll();
    }
}