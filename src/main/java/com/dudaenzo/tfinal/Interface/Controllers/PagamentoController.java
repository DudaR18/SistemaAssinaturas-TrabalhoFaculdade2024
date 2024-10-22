package com.dudaenzo.tfinal.Aplicacao.Controllers;

import com.dudaenzo.tfinal.Dominio.Entidade.PagamentoModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IPagamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/pagamentos")
public class PagamentoController {

    @Autowired
    private IPagamentoRepositorio pagamentoRepositorio;

    // Endpoint para listar todos os pagamentos
    @GetMapping
    public ResponseEntity<List<PagamentoModel>> listarPagamentos() {
        List<PagamentoModel> pagamentos = pagamentoRepositorio.allPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    // Endpoint para buscar um pagamento por ID
    @GetMapping("/{codigo}")
    public ResponseEntity<PagamentoModel> buscarPagamentoPorCodigo(@PathVariable long codigo) {
        PagamentoModel pagamento = pagamentoRepositorio.buscarPorCodigo(codigo);
        if (pagamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pagamento);
    }

    // Endpoint para criar ou atualizar um pagamento
    @PostMapping
    public ResponseEntity<PagamentoModel> salvarPagamento(@RequestBody PagamentoModel pagamento) {
        PagamentoModel novoPagamento = pagamentoRepositorio.salvarPagamento(pagamento);
        return ResponseEntity.ok(novoPagamento);
    }

    // Endpoint para remover um pagamento
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> removerPagamento(@PathVariable long codigo) {
        pagamentoRepositorio.removerPagamento(codigo);
        return ResponseEntity.noContent().build();
    }
}
