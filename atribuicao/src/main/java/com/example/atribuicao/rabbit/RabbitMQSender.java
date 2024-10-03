package com.example.atribuicao.rabbit;

import com.example.atribuicao.DTO.AtribuicaoDTO;
import com.example.atribuicao.models.Atribuicao;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Jackson2JsonMessageConverter jsonMessageConverter;

    public void enviarAtribuicaoParaFila(Atribuicao atribuicao) {
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        rabbitTemplate.convertAndSend("atribuicaoQueue", atribuicao);
        System.out.println("enviou");
    }
}
