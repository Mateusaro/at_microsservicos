package com.example.banco.controller;

import com.example.banco.models.Atribuicao;
import com.example.banco.service.AtribuicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atribuicoes")
public class AtribuicaoController {

    @Autowired
    private AtribuicaoService atribuicaoService;

    @PostMapping
    public ResponseEntity<Atribuicao> criarAtribuicao(@RequestBody Atribuicao atribuicao) {
        Atribuicao novaAtribuicao = atribuicaoService.salvarAtribuicao(atribuicao);
        return ResponseEntity.ok(novaAtribuicao);
    }

    @GetMapping
    public List<Atribuicao> listarAtribuicoes() {
        return atribuicaoService.listarAtribuicoes();
    }
}
