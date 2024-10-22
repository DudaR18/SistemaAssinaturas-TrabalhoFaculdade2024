package com.dudaenzo.tfinal.Aplicacao.Controllers;

import com.dudaenzo.tfinal.Dominio.Entidade.AssinaturaModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IAssinaturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    @Autowired
    private IAssinaturaRepositorio assinaturaRepositorio;

    // Endpoint para listar todas as assinaturas (opcionalmente por status)
    @GetMapping("/{tipo}")
    public ResponseEntity<List<AssinaturaModel>> listarAssinaturas(@PathVariable String tipo) {
        List<AssinaturaModel> assinaturas;
        switch (tipo.toUpperCase()) {
            case "ATIVAS":
                assinaturas = assinaturaRepositorio.allAssinaturas().stream()
                    .filter(a -> a.getFimVigencia().after(new Date())) // Assinaturas ativas
                    .collect(Collectors.toList());
                break;
            case "CANCELADAS":
                assinaturas = assinaturaRepositorio.allAssinaturas().stream()
                    .filter(a -> a.getFimVigencia().before(new Date())) // Assinaturas canceladas
                    .collect(Collectors.toList());
                break;
            default:
                assinaturas = assinaturaRepositorio.allAssinaturas();
                break;
        }
        return ResponseEntity.ok(assinaturas);
    }

    // Endpoint para criar uma nova assinatura
    @PostMapping
    public ResponseEntity<AssinaturaModel> criarAssinatura(@RequestBody AssinaturaModel assinatura) {
        AssinaturaModel novaAssinatura = assinaturaRepositorio.salvar(assinatura);
        return ResponseEntity.ok(novaAssinatura);
    }

    // Endpoint para listar as assinaturas de um cliente
    @GetMapping("/asscli/{codcli}")
    public ResponseEntity<List<AssinaturaModel>> listarAssinaturasPorCliente(@PathVariable long codcli) {
        List<AssinaturaModel> assinaturas = assinaturaRepositorio.AssinaturasPorCliente(codcli);
        return ResponseEntity.ok(assinaturas);
    }

    // Endpoint para listar as assinaturas de um aplicativo
    @GetMapping("/assapp/{codapp}")
    public ResponseEntity<List<AssinaturaModel>> listarAssinaturasPorAplicativo(@PathVariable long codapp) {
        List<AssinaturaModel> assinaturas = assinaturaRepositorio.AssinaturasPorAplicativo(codapp);
        return ResponseEntity.ok(assinaturas);
    }

    // Endpoint para registrar um pagamento
    @PostMapping("/registrarpagamento")
    public ResponseEntity<String> registrarPagamento(@RequestParam long codass, @RequestParam double valorPago, @RequestParam(required = false) String promocao) {
        AssinaturaModel assinatura = assinaturaRepositorio.buscarPorCodigo(codass);
        if (assinatura == null) {
            return ResponseEntity.notFound().build();
        }
        String resultado = assinatura.processarPagamento(valorPago, promocao);
        assinaturaRepositorio.salvar(assinatura); // Atualiza a assinatura
        return ResponseEntity.ok(resultado);
    }

    // Endpoint para verificar se a assinatura é válida
    @GetMapping("/assinvalida/{codass}")
    public ResponseEntity<Boolean> verificarValidadeAssinatura(@PathVariable long codass) {
        AssinaturaModel assinatura = assinaturaRepositorio.buscarPorCodigo(codass);
        if (assinatura == null) {
            return ResponseEntity.notFound().build();
        }
        boolean isValida = assinatura.getFimVigencia().after(new Date());
        return ResponseEntity.ok(isValida);
    }
}
