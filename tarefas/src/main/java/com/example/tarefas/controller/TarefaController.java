package com.example.tarefas.controller;

import com.example.tarefas.DTO.TarefaDTO;
import com.example.tarefas.models.Tarefa;
import com.example.tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    public TarefaController() {
        System.out.println("TarefaController foi inicializado");
    }

    @PostMapping
    public TarefaDTO criarTarefa(@Valid @RequestBody TarefaDTO tarefaDTO) {
        System.out.println("chegou dentro do controlador");

        tarefaService.salvarTarefa(tarefaDTO);
        return tarefaDTO;
    }

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefa(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.buscarTarefaPorId(id);
        return ResponseEntity.ok(tarefa);
    }
}
