package com.example.atribuicao.feign;

import com.example.atribuicao.DTO.TarefaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tarefas", url = "http://tarefas:8081/tarefas") //tarefas
public interface TarefaClient {

    @GetMapping("/{id}")
    TarefaDTO buscarTarefaPorId(@PathVariable Long id);
}
