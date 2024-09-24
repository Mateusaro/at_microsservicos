package com.example.atribuicao.DTO;

import jakarta.validation.constraints.NotNull;

public class AtribuicaoDTO {

    @NotNull
    private Long idTarefa;

    @NotNull
    private String usuarioAtribuido;

    // Getters e Setters
    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getUsuarioAtribuido() {
        return usuarioAtribuido;
    }

    public void setUsuarioAtribuido(String usuarioAtribuido) {
        this.usuarioAtribuido = usuarioAtribuido;
    }
}
