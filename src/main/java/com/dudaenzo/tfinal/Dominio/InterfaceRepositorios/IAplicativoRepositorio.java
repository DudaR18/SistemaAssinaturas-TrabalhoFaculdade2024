package com.dudaenzo.tfinal.Dominio.InterfaceRepositorios;

import java.util.List;

import com.dudaenzo.tfinal.Dominio.Entidade.AplicativoModel;

public interface IAplicativoRepositorio {
    List<AplicativoModel> allAplicativos();

    AplicativoModel consultaPorCodigo(long codigo);

    AplicativoModel consultaPorNome(String nome);

    AplicativoModel consultaPorCustoMensal(double customensal);

    AplicativoModel salvarApp(AplicativoModel app); // novo app ou atualizar um existente

    void removerApp(long codigo);

    void attCusto();
}
