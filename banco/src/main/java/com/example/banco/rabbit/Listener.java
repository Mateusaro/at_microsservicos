package com.example.banco.rabbit;

import com.example.banco.models.Atribuicao;
import com.example.banco.models.Tarefa;
import com.example.banco.service.AtribuicaoService;
import com.example.banco.service.TarefaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private AtribuicaoService atribuicaoService;

    @RabbitListener(queues = "tarefaQueue")
    public void processarTarefa(Tarefa tarefa) {
        // Converter o TarefaDTO para a entidade Tarefa
        Tarefa tarefa_n = new Tarefa();
        tarefa_n.setTitulo(tarefa.getTitulo());
        tarefa_n.setDescricao(tarefa.getDescricao());
        tarefa_n.setPrioridade(tarefa.getPrioridade());
        tarefa_n.setPrazo(tarefa.getPrazo());

        // Salvar a tarefa
        tarefaService.salvarTarefa(tarefa_n);
        System.out.println("Tarefa recebida e salva: " + tarefa_n.getTitulo());
    }

    @RabbitListener(queues = "atribuicaoQueue")
    public void processarAtribuicao(Atribuicao atribuicao) {
        Atribuicao atribuicao_n = new Atribuicao();
        atribuicao_n.setIdTarefa(atribuicao.getIdTarefa());
        atribuicao_n.setUsuarioAtribuido(atribuicao.getUsuarioAtribuido());
        atribuicao_n.setDataAtribuicao(atribuicao.getDataAtribuicao());

        // Salvar a atribuição
        atribuicaoService.salvarAtribuicao(atribuicao_n);
        System.out.println("Atribuição recebida e salva: " + atribuicao_n.getUsuarioAtribuido());
    }
}
