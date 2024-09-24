package com.example.atribuicao.controller;

import com.example.atribuicao.DTO.AtribuicaoDTO;
import com.example.atribuicao.models.Atribuicao;
import com.example.atribuicao.service.AtribuicaoService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Atribuicao> atribuirTarefa(@Valid @RequestBody AtribuicaoDTO atribuicaoDTO) {
        Atribuicao novaAtribuicao = atribuicaoService.atribuirTarefa(atribuicaoDTO);
        return ResponseEntity.ok(novaAtribuicao);
    }

    @GetMapping
    public List<Atribuicao> listarAtribuicoes() {
        return atribuicaoService.listarAtribuicoes();
    }
}
