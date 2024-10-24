package com.dudaenzo.tfinal.Dominio.Entidade;

public class Usuario {
    private String usuario;
    private String senha;

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
}
