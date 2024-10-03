package com.example.tarefas.rabbit;

import com.example.tarefas.DTO.TarefaDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Jackson2JsonMessageConverter jsonMessageConverter;


    @Value("${tarefas.queue.name}")
    private String tarefaQueue;

    public String enviarTarefa(TarefaDTO tarefaDTO) {
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        rabbitTemplate.convertAndSend(tarefaQueue, tarefaDTO);
        return("Tarefa enviada para a fila: " + tarefaDTO.getTitulo());
    }
}
