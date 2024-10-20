package com.dudaenzo.tfinal.Dominio.Entidade;

public class AplicativoModel {
    private long codigo;
    private String nome;
    private double custoMensal;

    public AplicativoModel(long codigo, String nome, double custoMensal){
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

}
