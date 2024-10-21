package com.dudaenzo.tfinal.Interface.Repositorios.ImplementacoesJPA;

import java.util.List;
import java.util.Optional;

import com.dudaenzo.tfinal.Dominio.Entidade.UsuarioModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IUsuarioRepositorio;
import com.dudaenzo.tfinal.Interface.Repositorios.Entidade.Usuario;
import com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA.UsuarioJPA_ItRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class UsuarioRepJPA implements IUsuarioRepositorio {

    @Autowired
    private UsuarioJPA_ItRep usuarioJPA;

    public UsuarioModel buscarPorUsuario(String usuario) {
        Optional<Usuario> userEntity = usuarioJPA.findById(usuario);
        return userEntity.map(Usuario::toUsuarioModel).orElse(null);
    }

    public UsuarioModel salvarUsuario(UsuarioModel usuarioModel) {
        Usuario usuarioEntity = Usuario.fromUsuarioModel(usuarioModel);
        Usuario savedUsuario = usuarioJPA.save(usuarioEntity);
        return Usuario.toUsuarioModel(savedUsuario);
    }

    public List<UsuarioModel> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioJPA.findAll();
        return usuarios.stream().map(Usuario::toUsuarioModel).toList();
    }

    public List<UsuarioModel> buscarPorNome(String nome) {
        List<Usuario> usuarios = usuarioJPA.findByNomeContaining(nome);
        return usuarios.stream().map(Usuario::toUsuarioModel).toList();
    }
}
