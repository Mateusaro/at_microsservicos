package com.example.atribuicao;

import com.example.atribuicao.controller.AtribuicaoController;
import com.example.atribuicao.models.Atribuicao;
import com.example.atribuicao.service.AtribuicaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListarAtribuicoesControllerTest {

    @Mock
    private AtribuicaoService atribuicaoService;

    @InjectMocks
    private AtribuicaoController atribuicaoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarAtribuicoes() {
        Atribuicao atribuicao1 = new Atribuicao(1L, "teste123", LocalDateTime.now());
        Atribuicao atribuicao2 = new Atribuicao(2L, "teste456", LocalDateTime.now());
        when(atribuicaoService.listarAtribuicoes()).thenReturn(Arrays.asList(atribuicao1, atribuicao2));
        List<Atribuicao> atribuicoes = atribuicaoController.listarAtribuicoes();
        assertEquals(2, atribuicoes.size());
        assertEquals(atribuicao1, atribuicoes.get(0));
        assertEquals(atribuicao2, atribuicoes.get(1));
    }
}
