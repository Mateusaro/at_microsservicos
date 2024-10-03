package com.example.tarefas.feign;

import com.example.tarefas.DTO.TarefaDTO;
import com.example.tarefas.models.Tarefa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "banco", url = "http://banco:8080") //banco
public interface BancoClient {
    @PostMapping("/tarefas")
    Tarefa criarTarefa(@RequestBody TarefaDTO tarefa);

    @GetMapping("/tarefas")
    List<Tarefa> listarTarefas();

    @GetMapping("/tarefas/{id}")
    Tarefa buscarTarefaPorId(@PathVariable Long id);
}
