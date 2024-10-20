package com.dudaenzo.tfinal.Interface.Repositorios.Entidade;

import com.dudaenzo.tfinal.Dominio.Entidade.ClienteModel;

import jakarta.persistence.Entity;
import jakarta.persistence.codigo;

@Entity
public class Cliente {
    @codigo
    private long codigo;
    private String nome;
    private String email;

    protected Cliente() {
    }

    public Cliente(long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public long getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String ToString(){
        return "Cliente [codigo=" + codigo + ", email=" + email + ", nome=" + nome + "]";
    }

    public static Cliente fromClienteModel(ClienteModel pModel){
        return new Cliente(pModel.getCodigo(),pModel.getEmail(),pModel.getNome());
    }

    public static ClienteModel toClienteModel(Cliente prod){
        return new ClienteModel(prod.getCodigo(),prod.getEmail(),prod.getNome());
    }
}
