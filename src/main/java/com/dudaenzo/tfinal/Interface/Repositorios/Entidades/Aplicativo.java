package com.dudaenzo.tfinal.Interface.Repositorios.Entidade;

import com.dudaenzo.tfinal.Dominio.Entidade.AplicativoModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aplicativo {
    @Id
    private long codigo;
    private String nome;
    private double custoMensal;

    protected Aplicativo(){ }

    public Aplicativo(long codigo, String nome, double custoMensal){
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public long getCodigo(){
        return this.codigo;
    }

    public String getNome(){
        return this.nome;
    }

    public double getCustoMensal(){
        return this.custoMensal;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nome='" + getNome() + "'" +
            ", custoMensal='" + getCustoMensal() + "'" +
            "}";
    }

    public static Aplicativo fromAplicativoModel(AplicativoModel pModel){
        return new Aplicativo(pModel.getCodigo(),pModel.getCustoMensal(),pModel.getNome());
    }

    public static AplicativoModel toAplicativoModel(Aplicativo prod){
        return new AplicativoModel(prod.getCodigo(),prod.getCustoMensal(),prod.getNome());
    }
}
