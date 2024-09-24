package com.example.tarefas.models;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class Tarefa {

    private Long id;

    @NotNull
    private String titulo;
    private String descricao;

    @NotNull
    private LocalDate prazo;
    private Prioridade prioridade;

    public Tarefa() {}

    public Tarefa(Long id, String titulo, String descricao, LocalDate prazo, Prioridade prioridade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
