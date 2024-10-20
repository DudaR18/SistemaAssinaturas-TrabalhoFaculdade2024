package com.dudaenzo.tfinal.Dominio.Entidade;

public class AssinaturaModel {

    private long codigo;
    private Aplicativo aplicativo;
    private Cliente cliente;
    private Date inicioVigencia;
    private Date fimVigencia;

    public AssinaturaModel(long codigo, Date inicioVigencia, Date fimVigencia, Aplicativo aplicativo, Cliente cliente){
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
}