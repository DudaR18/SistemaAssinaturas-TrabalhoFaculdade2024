package com.dudaenzo.tfinal.Interface.Repositorios.ImplementacoesMemoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dudaenzo.tfinal.Dominio.Entidade.UsuarioModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IUsuarioRepositorio;

@Repository
public class UsuarioRepMem implements IUsuarioRepositorio {

    private List<UsuarioModel> usuarios = new ArrayList<>();

    public UsuarioModel buscarPorCodigo(String usuario) {
        Optional<UsuarioModel> user = usuarios.stream()
                .filter(u -> u.getUsuario().equals(usuario))
                .findFirst();
        return user.orElse(null);
    }

    public UsuarioModel salvarUsuario(UsuarioModel usuarioModel) {
        usuarios.removeIf(u -> u.getUsuario().equals(usuarioModel.getUsuario()));
        usuarios.add(usuarioModel);
        return usuarioModel;
    }

    public List<UsuarioModel> listarTodosUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public List<UsuarioModel> buscarPorNome(String nome) {
        List<UsuarioModel> resultados = new ArrayList<>();
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getUsuario().contains(nome)) {
                resultados.add(usuario);
            }
        }
        return resultados;
    }
}
