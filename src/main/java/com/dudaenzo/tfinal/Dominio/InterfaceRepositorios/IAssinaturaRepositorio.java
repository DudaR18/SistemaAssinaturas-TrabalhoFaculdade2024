package com.dudaenzo.tfinal.Dominio.InterfaceRepositorios;

import java.util.List;

import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;

public interface IAssinaturaRepositorio {
    List<AssinaturaModel> allAssinaturas();

    AssinaturaModel buscarPorCodigo(long codigo);

    AssinaturaModel salvar(AssinaturaModel assinatura); // nova assinatura ou att

    void remover(long id);

    List<AssinaturaModel> AssinaturasPorCliente(long codigo);

    List<AssinaturaModel> AssinaturasPorAplicativo(long codigo);
}