package com.example.atribuicao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    @Autowired
    private JavaMailSender mailSender;

    public void notificarUsuario(String email, String tituloTarefa) {
        String assunto = "Nova Tarefa Atribuída";
        String corpo = "Você foi atribuído à tarefa: " + tituloTarefa;

        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(email);
        mensagem.setSubject(assunto);
        mensagem.setText(corpo);
        System.out.println("Enviando mensagem");

        mailSender.send(mensagem);
    }
}
