package com.example.banco.Atribuicao;

import com.example.banco.controller.AtribuicaoController;
import com.example.banco.models.Atribuicao;
import com.example.banco.service.AtribuicaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CriarAtribuicaoControllerTest {

    @Mock
    private AtribuicaoService atribuicaoService;

    @InjectMocks
    private AtribuicaoController atribuicaoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarAtribuicao() {
        Atribuicao atribuicao = new Atribuicao(1L, "Teste", LocalDateTime.now());
        when(atribuicaoService.salvarAtribuicao(atribuicao)).thenReturn(atribuicao);
        ResponseEntity<Atribuicao> response = atribuicaoController.criarAtribuicao(atribuicao);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(atribuicao, response.getBody());
    }
}
