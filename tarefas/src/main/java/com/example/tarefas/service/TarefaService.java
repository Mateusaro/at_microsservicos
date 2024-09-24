package com.example.tarefas.service;

import com.example.tarefas.DTO.TarefaDTO;
import com.example.tarefas.feign.BancoClient;
import com.example.tarefas.models.Tarefa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private BancoClient bancoClient;

    public Tarefa salvarTarefa(@Valid TarefaDTO tarefa) {
        System.out.println("chegou dentro do service");
        return bancoClient.criarTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return bancoClient.listarTarefas();
    }

    public Tarefa buscarTarefaPorId(Long id) {
        return bancoClient.buscarTarefaPorId(id);
    }
}
