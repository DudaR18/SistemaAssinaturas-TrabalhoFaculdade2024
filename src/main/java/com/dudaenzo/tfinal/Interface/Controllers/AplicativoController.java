package com.dudaenzo.tfinal.Aplicacao.Controllers;

import com.dudaenzo.tfinal.Dominio.Entidade.AplicativoModel;
import com.dudaenzo.tfinal.Dominio.InterfaceRepositorios.IAplicativoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {

    @Autowired
    private IAplicativoRepositorio aplicativoRepositorio;

    // Endpoint para listar todos os aplicativos
    @GetMapping
    public ResponseEntity<List<AplicativoModel>> listarAplicativos() {
        List<AplicativoModel> aplicativos = aplicativoRepositorio.allAplicativos();
        return ResponseEntity.ok(aplicativos);
    }

    // Endpoint para atualizar o custo mensal de um aplicativo
    @PostMapping("/atualizacusto/{idAplicativo}")
    public ResponseEntity<AplicativoModel> atualizarCusto(@PathVariable long idAplicativo, @RequestBody double custo) {
        AplicativoModel aplicativo = aplicativoRepositorio.consultaPorCodigo(idAplicativo);
        if (aplicativo == null) {
            return ResponseEntity.notFound().build();
        }
        aplicativo.setCustoMensal(custo);
        aplicativoRepositorio.salvarApp(aplicativo);
        return ResponseEntity.ok(aplicativo);
    }
}
