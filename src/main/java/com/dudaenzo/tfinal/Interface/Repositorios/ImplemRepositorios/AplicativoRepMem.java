package com.dudaenzo.tfinal.Interface.Repositorios.implemRepositorios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IAplicativoRepositorio;
import com.dudaenzo.tfinal.Dominio.Entidade.AplicativoModel;

@Repository
public class AplicativoRepMem implements IAplicativoRepositorio {
    private List<AplicativoModel> aplicativos;

    public AplicativoRepMem() {
        aplicativos = new LinkedList<>();
        // Adicionando alguns aplicativos iniciais
        aplicativos.add(new AplicativoModel(10, "Spotify", 19.90));
        aplicativos.add(new AplicativoModel(20, "Netflix", 34.90));
        aplicativos.add(new AplicativoModel(30, "Amazon Prime", 29.90));
        aplicativos.add(new AplicativoModel(40, "Disney+", 27.90));
        aplicativos.add(new AplicativoModel(50, "YouTube Premium", 23.90));
    }

    public List<AplicativoModel> allAplicativos() {
        return aplicativos;
    }

    public AplicativoModel consultaPorCodigo(long codigo) {
        return aplicativos.stream()
                .filter(app -> app.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    public AplicativoModel consultaPorNome(String nome) {
        return aplicativos.stream()
                .filter(app -> app.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public AplicativoModel consultaPorCustoMensal(double custoMensal) {
        return aplicativos.stream()
                .filter(app -> app.getCustoMensal() == custoMensal)
                .findFirst()
                .orElse(null);
    }

    public AplicativoModel salvarApp(AplicativoModel app) {
        AplicativoModel existingApp = consultaPorCodigo(app.getCodigo());
        if (existingApp != null) {
            aplicativos.remove(existingApp);
        }
        aplicativos.add(app);
        return app;
    }

    public void removerApp(long codigo) {
        aplicativos.removeIf(app -> app.getCodigo() == codigo);
    }

    public void attCusto() {
        aplicativos.forEach(app -> {
            // Aumentar o custo em 5%
            double novoCusto = app.getCustoMensal() * 1.05;
            app.setCustoMensal(novoCusto);
        });
    }

}
