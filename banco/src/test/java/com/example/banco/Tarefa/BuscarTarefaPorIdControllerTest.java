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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BuscarTarefaPorIdControllerTest {

    @Mock
    private TarefaService tarefaService;

    @InjectMocks
    private TarefaController tarefaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarTarefaPorId() {
        Tarefa tarefa = new Tarefa("Projeto", "Descrição teste", "ALTA", LocalDate.now());
        tarefa.setId(1L);
        when(tarefaService.buscarTarefaPorId(1L)).thenReturn(Optional.of(tarefa));
        ResponseEntity<Tarefa> response = tarefaController.buscarTarefaPorId(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(tarefa, response.getBody());
    }

    @Test
    void buscarTarefaPorId_NotFound() {
        when(tarefaService.buscarTarefaPorId(1L)).thenReturn(Optional.empty());
        ResponseEntity<Tarefa> response = tarefaController.buscarTarefaPorId(1L);
        assertEquals(404, response.getStatusCodeValue());
    }
}
