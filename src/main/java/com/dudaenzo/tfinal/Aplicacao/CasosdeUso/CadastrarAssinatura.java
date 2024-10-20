package com.dudaenzo.tfinal.Aplicacao.CasosDeUso;

import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;
import com.dudaenzo.tfinal.Dominio.Entidade.AplicativoModel;
import com.dudaenzo.tfinal.Dominio.Entidade.ClienteModel;
import com.dudaenzo.tfinal.Repositorios.Entidades.IAplicativoRepositorio;
import com.dudaenzo.tfinal.Repositorios.Entidades.IClienteRepositorio;
import com.dudaenzo.tfinal.Repositorios.Entidades.IAssinaturaRepositorio;

import java.time.LocalDate;

public class CadastrarAssinatura {
    private IAssinaturaRepositorio assinaturaRepositorio;
    private IAplicativoRepositorio aplicativoRepositorio;
    private IClienteRepositorio clienteRepositorio;

    public CadastrarAssinatura(IAssinaturaRepositorio assinaturaRepositorio,
                               IAplicativoRepositorio aplicativoRepositorio,
                               IClienteRepositorio clienteRepositorio) {
        this.assinaturaRepositorio = assinaturaRepositorio;
        this.aplicativoRepositorio = aplicativoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    public AssinaturaModel executar(Long codigoCliente, Long codigoAplicativo) {
        ClienteModel cliente = clienteRepositorio.findById(codigoCliente);
        AplicativoModel aplicativo = aplicativoRepositorio.findById(codigoAplicativo);

        if (cliente == null || aplicativo == null) {
            throw new RuntimeException("Cliente ou aplicativo não encontrado!");
        }

        AssinaturaModel assinatura = new AssinaturaModel(cliente, aplicativo, LocalDate.now(), LocalDate.now().plusDays(7));
        return assinaturaRepositorio.save(assinatura);
    }
}