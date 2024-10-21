package com.dudaenzo.tfinal.Dominio.Entidade;

import java.util.Date;
import java.util.Calendar;

public class AssinaturaModel {

    private long codigo;
    private Aplicativo aplicativo;
    private Cliente cliente;
    private Date inicioVigencia;
    private Date fimVigencia;

    public AssinaturaModel(long codigo, Date inicioVigencia, Aplicativo aplicativo, Cliente cliente){
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = adicionarDias(inicioVigencia, 7); // 7 dias grátis
        this.aplicativo = aplicativo;
        this.cliente = cliente;
    }

    public long getCodigo(){
        return this.codigo;
    }

    public Date getInicioVigencia(){
        return this.inicioVigencia;
    }

    public Date getFimVigencia(){
        return this.fimVigencia;
    }

    public Aplicativo getAplicativo(){
        return this.aplicativo;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    private Date adicionarDias(Date data, int dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH, dias);
        return cal.getTime();
    }

    public String processarPagamento(double valorPago, String promocao) {
        double valorMensalidade = this.aplicativo.getCustoMensal();
        int diasExtras = 30; 

        if (valorPago == valorMensalidade) {
            this.fimVigencia = estenderValidade(this.fimVigencia, diasExtras);
            return "Novo prazo de validade: " + this.fimVigencia;
        }

        if (promocao != null && !promocao.isEmpty()) {
            if (promocao.equals("PROMO10")) {
                diasExtras = 45; // Promoção específica
                this.fimVigencia = estenderValidade(this.fimVigencia, diasExtras);
                return "Promoção aplicada. Novo prazo de validade: " + this.fimVigencia;
            } else if (promocao.equals("PROMO20") && valorPago == valorMensalidade * 12 * 0.6) {
                diasExtras = 365; // Pagamento anual com desconto
                this.fimVigencia = estenderValidade(this.fimVigencia, diasExtras);
                return "Pagamento anual aplicado. Novo prazo de validade: " + this.fimVigencia;
            }
        }

        return "Valor pago incorreto ou promoção inválida. Valor a ser estornado: " + valorPago;
    }

    private Date estenderValidade(Date fimAtual, int dias) {
        Date dataAtual = new Date();
        if (fimAtual.after(dataAtual)) {
            return adicionarDias(fimAtual, dias);
        } else {
            return adicionarDias(dataAtual, dias);
        }
    }

    public String toString() {
        return "{" +
            " codigo= '" + getCodigo() + "'" +
            ", inicioVigencia= '" + getInicioVigencia() + "'" +
            ", fimVigencia= '" + getFimVigencia() + "'" +
            ", Aplicativo= '" + getAplicativo() + "'" +
            ", Cliente= '" + getCliente() + "'" +
            "}";
    }
}
