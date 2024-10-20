package com.dudaenzo.tfinal.Aplicacao.DTOs;

public class UsuarioDTO {
    private String usuario;
    private String senha;

    // Construtor com parâmetros
    public UsuarioDTO(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    // Getters e Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}