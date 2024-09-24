package com.example.atribuicao;

import com.example.atribuicao.DTO.AtribuicaoDTO;
import com.example.atribuicao.DTO.TarefaDTO;
import com.example.atribuicao.controller.AtribuicaoController;
import com.example.atribuicao.models.Atribuicao;
import com.example.atribuicao.service.AtribuicaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AtribuirTarefaControllerTest {

    @Mock
    private AtribuicaoService atribuicaoService;

    @InjectMocks
    private AtribuicaoController atribuicaoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void atribuirTarefa() {
        AtribuicaoDTO atribuicaoDTO = new AtribuicaoDTO();
        atribuicaoDTO.setIdTarefa(1L);
        atribuicaoDTO.setUsuarioAtribuido("teste123");
        Atribuicao atribuicao = new Atribuicao(1L, "teste123", LocalDateTime.now());
        when(atribuicaoService.atribuirTarefa(atribuicaoDTO)).thenReturn(atribuicao);
        ResponseEntity<Atribuicao> response = atribuicaoController.atribuirTarefa(atribuicaoDTO);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(atribuicao, response.getBody());
    }
}
