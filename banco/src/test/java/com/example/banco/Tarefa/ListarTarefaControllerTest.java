package com.example.banco.Tarefa;

import com.example.banco.controller.TarefaController;
import com.example.banco.models.Tarefa;
import com.example.banco.service.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListarTarefaControllerTest {

    @Mock
    private TarefaService tarefaService;

    @InjectMocks
    private TarefaController tarefaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTarefas() {
        Tarefa tarefa1 = new Tarefa("Teste Titulo1", "Teste Descricao1", "ALTA", LocalDate.now());
        Tarefa tarefa2 = new Tarefa("Teste Titulo2", "Teste Descricao2", "MEDIA", LocalDate.now());
        when(tarefaService.listarTarefas()).thenReturn(Arrays.asList(tarefa1, tarefa2));
        List<Tarefa> tarefas = tarefaController.listarTarefas();
        assertEquals(2, tarefas.size());
        assertEquals(tarefa1, tarefas.get(0));
        assertEquals(tarefa2, tarefas.get(1));
    }
}
