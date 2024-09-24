package com.example.tarefas;

import com.example.tarefas.controller.TarefaController;
import com.example.tarefas.models.Tarefa;
import com.example.tarefas.models.Prioridade;
import com.example.tarefas.service.TarefaService;
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
        Tarefa tarefa1 = new Tarefa(1L, "Teste Titulo1", "Teste Descricao1", LocalDate.now().plusDays(7), Prioridade.ALTA);
        Tarefa tarefa2 = new Tarefa(2L, "Teste Titulo2", "Teste Descricao2", LocalDate.now().plusDays(3), Prioridade.MEDIA);
        when(tarefaService.listarTarefas()).thenReturn(Arrays.asList(tarefa1, tarefa2));
        List<Tarefa> tarefas = tarefaController.listarTarefas();
        assertEquals(2, tarefas.size());
        assertEquals(tarefa1, tarefas.get(0));
        assertEquals(tarefa2, tarefas.get(1));
    }
}
