package com.example.tarefas.service;

import com.example.tarefas.DTO.TarefaDTO;
import com.example.tarefas.feign.BancoClient;
import com.example.tarefas.models.Tarefa;
import com.example.tarefas.rabbit.RabbitSender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private BancoClient bancoClient;

    @Autowired
    private RabbitSender rabbitSender;

    public String salvarTarefa(@Valid TarefaDTO tarefa) {
       // System.out.println("chegou dentro do service");
        //return bancoClient.criarTarefa(tarefa);
        //rabbitSender.enviarTarefa(tarefa);

        return rabbitSender.enviarTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return bancoClient.listarTarefas();
    }

    public Tarefa buscarTarefaPorId(Long id) {
        return bancoClient.buscarTarefaPorId(id);
    }
}
