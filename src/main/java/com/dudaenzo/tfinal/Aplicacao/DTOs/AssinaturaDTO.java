package com.dudaenzo.tfinal.Aplicacao.DTOs;

import java.time.LocalDate;

public class AssinaturaDTO {
    private Long codigo;
    private Long clienteId;
    private Long aplicativoId;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    public AssinaturaDTO(Long codigo, Long clienteId, Long aplicativoId, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.clienteId = clienteId;
        this.aplicativoId = aplicativoId;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    // Getters e Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getAplicativoId() {
        return aplicativoId;
    }

    public void setAplicativoId(Long aplicativoId) {
        this.aplicativoId = aplicativoId;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }
}