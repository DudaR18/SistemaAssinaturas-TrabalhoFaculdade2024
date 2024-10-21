package com.dudaenzo.tfinal.Interface.Repositorios.implemRepositorios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IAssinaturaRepositorio;
import com.dudaenzo.tfinal.Interface.Repositorios.Entidade.Assinaturas;
import com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA.AssinaturaJPA_ItRep;

@Repository
@Primary
public class AssinaturaRepJPA implements IAssinaturaRepositorio {
    

    @Autowired
    private AssinaturaJPA_ItRep assinaturaJPA;

    public List<AssinaturaModel> allAssinaturas() {
        return assinaturaJPA.findAll().stream()
                .map(Assinaturas::toAssinaturaModel)
                .collect(Collectors.toList());
    }

    public AssinaturaModel buscarPorCodigo(long codigo) {
        Assinaturas assinatura = assinaturaJPA.findById(codigo).orElse(null);
        return assinatura != null ? Assinaturas.toAssinaturaModel(assinatura) : null;
    }

    public AssinaturaModel salvar(AssinaturaModel assinaturaModel) {
        Assinaturas assinatura = Assinaturas.fromAssinaturaModel(assinaturaModel);
        Assinaturas savedAssinatura = assinaturaJPA.save(assinatura);
        return Assinaturas.toAssinaturaModel(savedAssinatura);
    }

    public void remover(long id) {
        assinaturaJPA.deleteById(id);
    }

    public List<AssinaturaModel> AssinaturasPorCliente(long codigo) {
        return assinaturaJPA.findByNomeContaining(new Cliente(codigo)).stream()
                .map(Assinaturas::toAssinaturaModel)
                .collect(Collectors.toList());
    }

    public List<AssinaturaModel> AssinaturasPorAplicativo(long codigo) {
        return assinaturaJPA.findByNomeContaining(new Aplicativo(codigo)).stream()
                .map(Assinaturas::toAssinaturaModel)
                .collect(Collectors.toList());
    }
}