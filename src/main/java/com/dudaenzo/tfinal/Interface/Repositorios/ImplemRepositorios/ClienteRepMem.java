package com.dudaenzo.tfinal.Interface.Repositorios.ImplemRepositorios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dudaenzo.tfinal.Dominio.Entidades.ClienteModel;
import com.dudaenzo.tfinal.Dominio.InterfRepositorios.IClienteRepositorio;

@Repository
public class ClienteRepMem implements IClienteRepositorio {
    private List<ClienteModel> clientes;

    public ClienteRepMem() {
        clientes = new LinkedList<>();
        clientes.add(new ClienteModel(1, "Duda Rubin", "duda.rubin@gmail.com"));
        clientes.add(new ClienteModel(2, "Enzo Stefanello", "enzo.stefanello@gmail.com"));
        clientes.add(new ClienteModel(3, "Luquinhas", "luquinhas@gmail.com"));
        clientes.add(new ClienteModel(4, "Luane Malheiros", "luane.malheiros@gmail.com"));
        clientes.add(new ClienteModel(5, "Parça God", "parça@gmail.com"));
    }

    public List<ClienteModel> allClientes() {
        return clientes;
    }

    public ClienteModel consultaPorId(long codigo) {
        return clientes.stream()
                .filter(cliente -> cliente.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    public ClienteModel consultaPorNome(String nome) {
        return clientes.stream()
                .filter(cliente -> cliente.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public ClienteModel consultaPorEmail(String email) {
        return clientes.stream()
                .filter(cliente -> cliente.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public ClienteModel salvarCliente(ClienteModel clienteModel) {
        // Verifica se o cliente já existe (baseado no código)
        ClienteModel existingCliente = consultaPorId(clienteModel.getCodigo());
        if (existingCliente != null) {
            // Atualiza cliente existente
            clientes.remove(existingCliente);
        }
        clientes.add(clienteModel);
        return clienteModel;
    }

    public void removerCliente(long id) {
        clientes.removeIf(cliente -> cliente.getCodigo() == id);
    }
}