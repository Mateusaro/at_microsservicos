package com.example.banco.Tarefa;

import com.example.banco.controller.TarefaController;
import com.example.banco.models.Tarefa;
import com.example.banco.service.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CriarTarefaControllerTest {

    @Mock
    private TarefaService tarefaService;

    @InjectMocks
    private TarefaController tarefaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarTarefa() {
        Tarefa tarefa = new Tarefa("Título", "Descrição", "Alta", LocalDate.now());
        when(tarefaService.salvarTarefa(tarefa)).thenReturn(tarefa);
        ResponseEntity<Tarefa> response = tarefaController.criarTarefa(tarefa);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(tarefa, response.getBody());
    }
}
