package com.dudaenzo.tfinal.Interface.Repositorios.implemRepositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IAplicativoRepositorio;
import com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA.AplicativoJPA_ItRep;
import com.dudaenzo.tfinal.Dominio.Entidade.AplicativoModel;

@Repository
@Primary
public class AplicativoRepJPA implements IAplicativoRepositorio {

    @Autowired
    private AplicativoJPA_ItRep aplicativoJPA;

    public List<AplicativoModel> allAplicativos() {
        return aplicativoJPA.findAll().stream()
                .map(Aplicativo::toAplicativoModel)
                .toList();
    }

    public AplicativoModel consultaPorCodigo(long codigo) {
        return aplicativoJPA.findById(codigo)
                .map(Aplicativo::toAplicativoModel)
                .orElse(null);
    }

    public AplicativoModel consultaPorNome(String nome) {
        return aplicativoJPA.findByNomeContaining(nome).stream()
                .findFirst()
                .map(Aplicativo::toAplicativoModel)
                .orElse(null);
    }

    public AplicativoModel consultaPorCustoMensal(double custoMensal) {
        return allAplicativos().stream()
                .filter(app -> app.getCustoMensal() == custoMensal)
                .findFirst()
                .orElse(null);
    }

    public AplicativoModel salvarApp(AplicativoModel app) {
        Aplicativo aplicativo = Aplicativo.fromAplicativoModel(app);
        aplicativoJPA.save(aplicativo);
        return app;
    }

    public void removerApp(long codigo) {
        aplicativoJPA.deleteById(codigo);
    }

public void attCusto() {
    allAplicativos().forEach(app -> {
        Aplicativo aplicativo = aplicativoJPA.findById(app.getCodigo()).orElse(null);
        if (aplicativo != null) {
            // Aumentar o custo em 5%
            double novoCusto = aplicativo.getCustoMensal() * 1.05;
            aplicativo.setCustoMensal(novoCusto);
            aplicativoJPA.save(aplicativo);
        }
    });
}

}
