package com.dudaenzo.tfinal.Interface.Repositorios.Entidade;

import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Assinaturas{
    @Id
    private long codigo;
    private Aplicativo aplicativo;
    private Cliente cliente;
    private Date inicioVigencia;
    private Date fimVigencia;

    protected Assinaturas(){ }

    public Assinaturas(long codigo, Date inicioVigencia, Date fimVigencia, Aplicativo aplicativo, Cliente cliente){
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
    }

    public long getCodigo(){
        return this.codigo;
    }

    public Date getinicioVigencia(){
        return this.inicioVigencia;
    }

    public Date getfimVigencia(){
        return this.fimVigencia;
    }

    public Aplicativo getAplicativo(){
        return this.aplicativo;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo= '" + getCodigo() + "'" +
            ", inicioVigencia= '" + getinicioVigencia() + "'" +
            ", fimVigencia= '" + getfimVigencia() + "'" +
            ", Aplicativo= '" + getAplicativo() + "'" +
            ", Cliente= '" + getCliente() + "'" +
            "}";
    }

    public static Assinaturas fromAssinaturaModel(AssinaturaModel pModel){
        return new Assinaturas(pModel.getCodigo(),pModel.getinicioVigencia(),pModel.getfimVigencia(), pModel.getAplicativo(), pModel.getCliente());
    }

    public static AssinaturaModel toAssinaturaModel(Assinaturas prod){
        return new AssinaturaModel(prod.getCodigo(),prod.getinicioVigencia(),prod.getfimVigencia(), prod.getAplicativo(), prod.getCliente());
    }
}
