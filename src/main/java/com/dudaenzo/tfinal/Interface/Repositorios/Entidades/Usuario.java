package com.dudaenzo.tfinal.Interface.Repositorios.Entidade;

import com.dudaenzo.tfinal.Dominio.Entidade.UsuarioModel;

import jakarta.persistence.Entity;

@Entity
public class Usuario {
    private String usuario;
    private String senha;

    protected Usuario(){ }

    public Usuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario(){
        return this.usuario;
    }

    public String getSenha(){
        return this.senha;
    }

    @Override
    public String toString() {
        return "{" +
            " Usuario= '" + getUsuario() + "'" +
            ", Senha= '" + getSenha() + "'" +
            "}";
    }

    public static Usuario fromUsuarioModel(UsuarioModel pModel){
        return new Usuario(pModel.getUsuario(),pModel.getSenha());
    }

    public static UsuarioModel toUsuarioModel(Usuario prod){
        return new UsuarioModel(prod.getUsuario(),prod.getEmail());
    }
}
