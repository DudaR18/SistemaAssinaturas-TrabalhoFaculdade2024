package com.dudaenzo.tfinal.Interface.Repositorios.implemRepositorios;

import java.util.LinkedList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.dudaenzo.tfinal.Dominio.Entidade.ClienteModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IClienteRepositorio;
import com.dudaenzo.tfinal.Interface.Repositorios.Entidades.Cliente;
import com.dudaenzo.tfinal.Interface.Repositorios.InterfaceJPA.ClienteJPA_ItfRep;

@Repository
@Primary
public class ClienteRepJPA implements IClienteRepositorio {
    private ClienteJPA_ItfRep ClienteRepository;

    //@Autowired
    public ClienteRepJPA(ClienteJPA_ItfRep ClienteRepository) {
        this.ClienteRepository = ClienteRepository;
    }

    public List<ClienteModel> allClientes() {
        List<Cliente> Clientes = ClienteRepository.findAll();
        if (Clientes.size() == 0) {
            return new LinkedList<ClienteModel>();
        } else {
            return Clientes.stream()
                    .map(prod -> Cliente.toClienteModel(prod))
                    .toList();
        }
    }

    public ClienteModel consultaPorCodigo(long id) {
        Cliente Cliente = ClienteRepository.findById(id);
        System.out.println("Cliente de codigo: "+id+": "+Cliente);
        if (Cliente == null) {
            return null;
        } else {
            return Cliente.toClienteModel(Cliente);
        }
    }

    public ClienteModel consultaPorNome(String nome) {
        Cliente Cliente = ClienteRepository.findById(nome);
        System.out.println("Cliente de Nome: "+nome+": "+Cliente);
        if (Cliente == null) {
            return null;
        } else {
            return Cliente.toClienteModel(Cliente);
        }
    }
    public ClienteModel consultaPorEmail(String email) {
        Cliente Cliente = ClienteRepository.findByemail(email);
        System.out.println("Cliente de Email: "+email+": "+Cliente);
        if (Cliente == null) {
            return null;
        } else {
            return Cliente.toClienteModel(Cliente);
        }
    }

    public ClienteModel salvarCliente(ClienteModel clienteModel) {
        Cliente cliente = Cliente.fromClienteModel(clienteModel);
        cliente = clienteJPARep.save(cliente);
        return cliente.toClienteModel();
    }

    public void removerCliente(long codigo) {
        clienteJPARep.deleteById(codigo);
    }
}
