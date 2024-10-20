package com.dudaenzo.tfinal.Aplicacao.DTOs;

public class AplicativoDTO {
    private Long codigo;
    private String nome;
    private Double custoMensal;

    public AplicativoDTO(Long codigo, String nome, Double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(Double custoMensal) {
        this.custoMensal = custoMensal;
    }
}