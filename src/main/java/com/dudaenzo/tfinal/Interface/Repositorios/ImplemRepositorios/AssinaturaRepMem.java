package com.dudaenzo.tfinal.Interface.Repositorios.implemRepositorios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Repository;

import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IAssinaturaRepositorio;
import com.dudaenzo.tfinal.Interface.Repositorios.Entidade.Assinaturas;

@Repository
public class AssinaturaRepMem implements IAssinaturaRepositorio {

    private List<AssinaturasModel> assinaturas;
    private ClienteRepMem clienteRepMem;
    private AplicativoRepMem aplicativoRepMem;

    public AssinaturaRepMem() {
        assinaturas = new ArrayList<>();
        clienteRepMem = new ClienteRepMem();
        aplicativoRepMem = new AplicativoRepMem();

        LocalDateTime inicioVigencia = LocalDateTime.now();
        LocalDateTime fimVigencia1 = inicioVigencia.plusDays(30); //1 mes
        LocalDateTime fimVigencia2 = inicioVigencia.plusDays(90); //2 meses
        LocalDateTime fimVigencia3 = inicioVigencia.plusDays(360); //12 meses (1 ano)
        
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        //System.out.println("Início: " + inicioVigencia.format(formatter));
        //System.out.println("Fim: " + fimVigencia.format(formatter));

        //ou new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000) 30 dias a partir do hrario atual

        assinaturas.add(new AssinaturaModel(100, new Date(fimVigencia3), new Date(inicioVigencia), aplicativoRepMem.consultaPorCodigo(10), clienteRepMem.consultaPorId(1))); // Spotify - Duda Rubin
        assinaturas.add(new AssinaturaModel(200, new Date(fimVigencia2), new Date(inicioVigencia), aplicativoRepMem.consultaPorCodigo(20), clienteRepMem.consultaPorId(2))); // Netflix - Enzo Stefanello
        assinaturas.add(new AssinaturaModel(300, new Date(fimVigencia1), new Date(inicioVigencia), aplicativoRepMem.consultaPorCodigo(30), clienteRepMem.consultaPorId(3))); // Amazon Prime - Luquinhas
}

    @Override
    public List<AssinaturaModel> allAssinaturas() {
        return assinaturas.stream()
                .map(Assinaturas::toAssinaturaModel)
                .collect(Collectors.toList());
    }

    @Override
    public AssinaturaModel buscarPorCodigo(long codigo) {
        return assinaturas.stream()
                .filter(a -> a.getCodigo() == codigo)
                .map(Assinaturas::toAssinaturaModel)
                .findFirst()
                .orElse(null);
    }

    @Override
    public AssinaturaModel salvar(AssinaturaModel assinaturaModel) {
        Assinaturas assinatura = Assinaturas.fromAssinaturaModel(assinaturaModel);
        assinaturas.removeIf(a -> a.getCodigo() == assinatura.getCodigo()); // Remove se já existir
        assinaturas.add(assinatura);
        return Assinaturas.toAssinaturaModel(assinatura);
    }

    @Override
    public void remover(long id) {
        assinaturas.removeIf(a -> a.getCodigo() == id);
    }

    @Override
    public List<AssinaturaModel> AssinaturasPorCliente(long codigo) {
        return assinaturas.stream()
                .filter(a -> a.getCliente().getCodigo() == codigo)
                .map(Assinaturas::toAssinaturaModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<AssinaturaModel> AssinaturasPorAplicativo(long codigo) {
        return assinaturas.stream()
                .filter(a -> a.getAplicativo().getCodigo() == codigo)
                .map(Assinaturas::toAssinaturaModel)
                .collect(Collectors.toList());
    }
}
