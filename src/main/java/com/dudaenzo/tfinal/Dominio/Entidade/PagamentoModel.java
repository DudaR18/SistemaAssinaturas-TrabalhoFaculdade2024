package com.dudaenzo.tfinal.Dominio.Entidade;

public class PagamentoModel {
    private long codigo;
    private double valorPago;
    private Date dataPagamento;
    private String promocao;
    private Assinaturas assinatura;

    public PagamentoModel(long codigo, double valorPago, Date dataPagamento, String promocao, Assinaturas assinatura){
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.assinatura = assinatura;
    }

    public long getCodigo(){
        return this.codigo;
    }

    public double getValorPago(){
        return this.valorPago;
    }

    public Date getDataPagamento(){
        return this.dataPagamento;
    }

    public String getPromocao(){
        return this.promocao;
    }

    public Assinaturas getAssinaturas(){
        return this.assinatura;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo= '" + getCodigo() + "'" +
            ", ValorPago= '" + getValorPago() + "'" +
            ", Promocao= '" + getPromocao() + "'" +
            ", Assinaturas= '" + getAssinaturas() + "'" +
            ", DataPagamento= '" + getDataPagamento() + "'" +
            "}";
    }
}
