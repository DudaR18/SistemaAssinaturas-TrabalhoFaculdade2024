package com.dudaenzo.tfinal.Interface.Repositorios.Entidade;

import com.dudaenzo.tfinal.Dominio.Entidade.PagamentoModel;

import jakarta.persistence.Entity;
import jakarta.persistence.codigo;

@Entity
public class Pagamento {
    @codigo
    private long codigo;
    private double valorPago;
    private Date dataPagamento;
    private String promocao;
    private Assinaturas assinatura;

    protected Pagamento(){ }

    public Pagamento(long codigo, double valorPago, Date dataPagamento, String promocao, Assinaturas assinatura){
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

    public static Pagamento fromPagamentoModel(PagamentoModel pModel){
        return new Pagamento(pModel.getCodigo(),pModel.getValorPago(),pModel.getDataPagamento(), pModel.getPromocao(), pModel.getAssinaturas());
    }

    public static PagamentoModel toPagamentoModel(Pagamento prod){
        return new PagamentoModel(prod.getCodigo(),prod.getValorPago(),prod.getDataPagamento(), prod.getPromocao(), prod.getAssinaturas());
    }
}
