package com.example.tarefas.DTO;

import com.example.tarefas.models.Prioridade;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class TarefaDTO {

    @NotNull
    private String titulo;

    private String descricao;

    @NotNull
    private LocalDate prazo;

    private Prioridade prioridade;

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}
