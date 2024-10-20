package com.dudaenzo.tfinal.Aplicacao.DTOs;

import java.time.LocalDate;

public class PagamentoDTO {
    private Long codigo;
    private Long assinaturaId;
    private Double valorPago;
    private LocalDate dataPagamento;

    // Construtor com parâmetros
    public PagamentoDTO(Long codigo, Long assinaturaId, Double valorPago, LocalDate dataPagamento) {
        this.codigo = codigo;
        this.assinaturaId = assinaturaId;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    // Getters e Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getAssinaturaId() {
        return assinaturaId;
    }

    public void setAssinaturaId(Long assinaturaId) {
        this.assinaturaId = assinaturaId;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}