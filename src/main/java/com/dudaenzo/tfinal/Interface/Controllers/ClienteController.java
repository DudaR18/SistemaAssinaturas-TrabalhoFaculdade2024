package com.dudaenzo.tfinal.Aplicacao.Controllers;

import com.dudaenzo.tfinal.Dominio.Entidade.ClienteModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/clientes")
public class ClienteController {

    @Autowired
    private IClienteRepositorio clienteRepositorio;

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarClientes() {
        List<ClienteModel> clientes = clienteRepositorio.allClientes();
        return ResponseEntity.ok(clientes);
    }

    // Endpoint para buscar um cliente por ID
    @GetMapping("/{codigo}")
    public ResponseEntity<ClienteModel> buscarClientePorCodigo(@PathVariable long codigo) {
        ClienteModel cliente = clienteRepositorio.consultaPorCodigo(codigo);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    // Endpoint para buscar um cliente por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<ClienteModel> buscarClientePorNome(@PathVariable String nome) {
        ClienteModel cliente = clienteRepositorio.consultaPorNome(nome);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    // Endpoint para buscar um cliente por email
    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteModel> buscarClientePorEmail(@PathVariable String email) {
        ClienteModel cliente = clienteRepositorio.consultaPorEmail(email);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    // Endpoint para criar ou atualizar um cliente
    @PostMapping
    public ResponseEntity<ClienteModel> salvarCliente(@RequestBody ClienteModel cliente) {
        ClienteModel novoCliente = clienteRepositorio.salvarCliente(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    // Endpoint para remover um cliente
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> removerCliente(@PathVariable long codigo) {
        clienteRepositorio.removerCliente(codigo);
        return ResponseEntity.noContent().build();
    }
}
